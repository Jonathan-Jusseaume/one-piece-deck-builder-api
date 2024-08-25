package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.*;
import com.onepiecedeckbuilder.entity.CardEntity;
import com.onepiecedeckbuilder.entity.DeckEntity;
import com.onepiecedeckbuilder.entity.UserEntity;
import com.onepiecedeckbuilder.exceptions.*;
import com.onepiecedeckbuilder.repository.CardRepository;
import com.onepiecedeckbuilder.repository.DeckRepository;
import com.onepiecedeckbuilder.repository.UserRepository;
import com.onepiecedeckbuilder.repository.specification.DeckSpecification;
import com.onepiecedeckbuilder.repository.specification.SpecificationBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class DeckService {

    public static final int MAX_CARDS_IN_DECK = 50;
    public static final int MAX_COPIES_NUMBER_OF_CARD_PER_DECK = 4;

    private final DeckRepository deckRepository;

    private final UserRepository userRepository;

    private final CardRepository cardRepository;

    public Page<Deck> list(Pageable pageable, boolean onlyUserDeck, Set<Color> colors, String keyword, User connectedUser,
                           boolean onlyFavorite, String language) throws UserUnauthorizedException {
        if ((onlyFavorite || onlyUserDeck) && connectedUser == null) {
            throw new UserUnauthorizedException();
        }
        if (pageable == null) {
            pageable = Pageable.ofSize(25);
        }
        SpecificationBuilder<DeckEntity> builder = new SpecificationBuilder<>();
        builder.with(DeckSpecification.distinct());
        addMailToFilter(builder, connectedUser, onlyUserDeck);
        addColorsToFilter(builder, colors);
        addKeywordToFilter(builder, keyword);
        addOnlyFavoriteToFilter(builder, connectedUser, onlyFavorite);
        Page<DeckEntity> results = deckRepository.findAll(builder.build(), pageable);
        return new PageImpl<>(
                results.getContent()
                        .stream()
                        .map(cardEntity -> new Deck(cardEntity, language,
                                (connectedUser != null) ? connectedUser.getMail() : null, false))
                        .toList(),
                pageable, results.getTotalElements());
    }

    public Deck read(UUID id, String language, String mail) throws DeckNotFoundException {
        return new Deck(this.readById(id), language, mail, true);
    }

    public Deck create(Deck deck, String language) throws DeckInvalidException, UserUnauthorizedException {
        if (!isDeckValid(deck)) {
            throw new DeckInvalidException();
        }
        if (deck.getUser() == null) {
            throw new UserUnauthorizedException();
        }
        UserEntity userToSave = this.saveUserIfNotExists(deck.getUser());
        deck.setId(UUID.randomUUID());
        deck.setUser(new User(userToSave));
        deck.setCreationDate(LocalDate.now(ZoneOffset.UTC));
        return new Deck(deckRepository.save(deck.toEntity()), language, userToSave.getMail(), true);
    }

    public Deck favorite(UUID id, User connectedUser, String language) throws DeckNotFoundException, DeckAlreadyFavoritedException, DeckNotFavoritedException {
        return favoriteAction(id, connectedUser, language, true);
    }

    public Deck unfavorite(UUID id, User connectedUser, String language) throws DeckNotFoundException, DeckAlreadyFavoritedException, DeckNotFavoritedException {
        return favoriteAction(id, connectedUser, language, false);
    }

    private Deck favoriteAction(UUID id, User connectedUser, String language, boolean makeFavorite) throws DeckNotFoundException, DeckAlreadyFavoritedException, DeckNotFavoritedException {
        DeckEntity deckEntity = this.readById(id);
        UserEntity userToSave = this.saveUserIfNotExists(connectedUser);
        if (deckEntity.isFavorite(userToSave.getMail()) && makeFavorite) {
            throw new DeckAlreadyFavoritedException();
        }
        if (!deckEntity.isFavorite(userToSave.getMail()) && !makeFavorite) {
            throw new DeckNotFavoritedException();
        }

        if (makeFavorite) {
            deckEntity.getUsersFavorite().add(userToSave);
            deckEntity.setCountFavorites(deckEntity.getCountFavorites() + 1);
        } else {
            deckEntity.setUsersFavorite(deckEntity.getUsersFavorite()
                    .stream()
                    .filter(userEntity -> !userEntity.getMail().equals(connectedUser.getMail()))
                    .collect(Collectors.toSet()));
            deckEntity.setCountFavorites(deckEntity.getCountFavorites() - 1);
        }
        return new Deck(deckRepository.save(deckEntity), language, userToSave.getMail(), false);
    }

    public void delete(UUID id, User user) throws DeckOwnershipException, DeckNotFoundException {
        Optional<DeckEntity> deckEntity = deckRepository.findById(id);
        if (deckEntity.isEmpty()) {
            throw new DeckNotFoundException();
        }
        if (!deckEntity.get().getUser().getMail().equals(user.getMail())) {
            throw new DeckOwnershipException();
        }
        this.deckRepository.deleteById(id);
    }

    private UserEntity saveUserIfNotExists(User user) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(user.getMail());
        return optionalUserEntity.orElseGet(() -> {
            user.setCreationDate(LocalDate.now(ZoneOffset.UTC));
            return userRepository.saveAndFlush(user.toEntity());
        });
    }

    private DeckEntity readById(UUID id) throws DeckNotFoundException {
        Optional<DeckEntity> deckEntity = deckRepository.findById(id);
        if (deckEntity.isEmpty()) {
            throw new DeckNotFoundException();
        }
        return deckEntity.get();
    }

    private boolean isDeckValid(Deck deck) {
        if (deck.getLeader() == null || deck.getLeader().getId() == null || deck.getName() == null
                || deck.getName().isEmpty()) {
            return false;
        }
        Optional<CardEntity> leaderEntityOptional = cardRepository.findById(deck.getLeader().getId());
        if (leaderEntityOptional.isEmpty() || !leaderEntityOptional.get().getType().equals(Type.LEADER)) {
            return false;
        }
        if (!validCardsNumbers(deck)) {
            return false;
        }
        return validCardsColors(deck, leaderEntityOptional.get());
    }

    private boolean validCardsNumbers(Deck deck) {
        if (deck.getCards() == null || deck.getCards().size() != MAX_CARDS_IN_DECK
                || deck.getCards().stream().anyMatch(card -> card == null || card.getId() == null)) {
            return false;
        }
        Set<String> distinctIds = deck.getCards()
                .stream()
                .map(Card::getId)
                .collect(Collectors.toSet());
        return distinctIds.stream().noneMatch(id ->
                deck.getCards()
                        .stream()
                        .filter(card -> card.getId().equals(id)).count() > MAX_COPIES_NUMBER_OF_CARD_PER_DECK
        );
    }

    private boolean validCardsColors(Deck deck, CardEntity leaderEntity) {
        List<CardEntity> cardEntities = cardRepository.findAllById(deck.getCards()
                .stream()
                .map(Card::getId)
                .toList());
        return cardEntities.stream().allMatch(cardEntity ->
                hasCardColorOfLeader(leaderEntity,
                        retrieveCardEntityFromListById(cardEntities, cardEntity.getId())));
    }

    private CardEntity retrieveCardEntityFromListById(List<CardEntity> cardEntities, String id) {
        return cardEntities
                .stream()
                .filter(cardEntity -> cardEntity.getId().equals(id))
                .findFirst().orElse(null);
    }

    private boolean hasCardColorOfLeader(CardEntity leader, CardEntity cardSelected) {
        return leader.getColors()
                .stream()
                .anyMatch(color -> cardSelected != null &&
                        cardSelected.getColors()
                                .stream()
                                .anyMatch(color::equals));
    }

    private void addMailToFilter(SpecificationBuilder<DeckEntity> builder, User userConnected, boolean onlyUserDeck) {
        if (onlyUserDeck && userConnected != null) {
            builder.with(DeckSpecification.byUserMail(userConnected.getMail()));
        }
    }

    private void addKeywordToFilter(SpecificationBuilder<DeckEntity> builder, String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            builder.with(DeckSpecification.byKeyword(keyword));
        }
    }

    private void addColorsToFilter(SpecificationBuilder<DeckEntity> builder, Set<Color> colors) {
        if (colors != null && !colors.isEmpty()) {
            builder.with(DeckSpecification.byColor(colors));
        }
    }

    private void addOnlyFavoriteToFilter(SpecificationBuilder<DeckEntity> builder, User connectedUser, boolean onlyFavorite) {
        if (connectedUser != null && connectedUser.getMail() != null && onlyFavorite) {
            builder.with(DeckSpecification.byUserFavoriteDeck(connectedUser.getMail()));
        }
    }


}
