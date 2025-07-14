package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.*;
import com.onepiecedeckbuilder.entity.CardEntity;
import com.onepiecedeckbuilder.entity.DeckEntity;
import com.onepiecedeckbuilder.entity.UserEntity;
import com.onepiecedeckbuilder.exceptions.*;
import com.onepiecedeckbuilder.mapper.DeckMapper;
import com.onepiecedeckbuilder.mapper.PaginationMapper;
import com.onepiecedeckbuilder.mapper.UserMapper;
import com.onepiecedeckbuilder.mapper.context.CustomMapperContext;
import com.onepiecedeckbuilder.repository.CardRepository;
import com.onepiecedeckbuilder.repository.DeckRepository;
import com.onepiecedeckbuilder.repository.search.DeckSearch;
import com.onepiecedeckbuilder.repository.specification.DeckSpecification;
import com.onepiecedeckbuilder.repository.specification.SpecificationBuilder;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class DeckService {

    public static final int MAX_CARDS_IN_DECK = 50;
    public static final int MAX_COPIES_NUMBER_OF_CARD_PER_DECK = 4;

    private final UserService userService;

    private final DeckRepository deckRepository;

    private final CardRepository cardRepository;

    private final DeckMapper deckMapper;

    private final UserMapper userMapper;

    private final PaginationMapper paginationMapper;

    public PagingResultWithFilters<Deck, DeckSearch> list(
        DeckSearch deckSearch,
        String language
    ) throws UserUnauthorizedException {
        User connectedUser = userService.getConnectedUser();
        if (
            (deckSearch.getOnlyFavorite() || deckSearch.getOnlyUserDeck()) &&
            connectedUser == null
        ) {
            throw new UserUnauthorizedException();
        }

        Page<DeckEntity> results = deckRepository.findAll(
            convertDeckSearchToSpecifications(deckSearch, connectedUser),
            paginationMapper.getPageable(deckSearch.getPagination())
        );

        return new PagingResultWithFilters<>(
            results
                .getContent()
                .stream()
                .map(deckEntity ->
                    deckMapper.toDto(
                        deckEntity,
                        CustomMapperContext.builder()
                            .languageCode(language)
                            .minimizeData(true)
                            .connectedUser(connectedUser)
                            .build()
                    )
                )
                .toList(),
            results.getTotalPages(),
            results.getTotalElements(),
            results.getSize(),
            results.getNumber(),
            results.isEmpty(),
            deckSearch
        );
    }

    private Specification<DeckEntity> convertDeckSearchToSpecifications(
        DeckSearch deckSearch,
        User connectedUser
    ) {
        SpecificationBuilder<DeckEntity> builder = new SpecificationBuilder<>();
        builder.with(DeckSpecification.distinct());
        addMailToFilter(builder, connectedUser, deckSearch.getOnlyUserDeck());
        addColorsToFilter(builder, deckSearch.getColors());
        addKeywordToFilter(builder, deckSearch.getKeyword());
        addOnlyFavoriteToFilter(
            builder,
            connectedUser,
            deckSearch.getOnlyFavorite()
        );
        return builder.build();
    }

    public Deck read(UUID id, String language) throws DeckNotFoundException {
        User connectedUser = userService.getConnectedUser();
        return this.deckMapper.toDto(
            this.readById(id),
            CustomMapperContext.builder()
                .languageCode(language)
                .connectedUser(connectedUser)
                .build()
        );
    }

    public Deck create(Deck deck, String language)
        throws DeckInvalidException, UserUnauthorizedException {
        if (!isDeckValid(deck)) {
            throw new DeckInvalidException();
        }
        User connectedUser = userService.getConnectedUser();
        if (connectedUser == null) {
            throw new UserUnauthorizedException();
        }
        userService.saveUserIfNotExists(connectedUser);
        deck.setId(UUID.randomUUID());
        deck.setCreationDate(LocalDate.now(ZoneOffset.UTC));
        return deckMapper.toDto(
            deckRepository.save(deck.toEntity()),
            CustomMapperContext.builder()
                .languageCode(language)
                .connectedUser(connectedUser)
                .build()
        );
    }

    public Deck favorite(UUID id, String language)
        throws DeckNotFoundException, DeckAlreadyFavoritedException, DeckNotFavoritedException {
        return favoriteAction(id, language, true);
    }

    public Deck unfavorite(UUID id, String language)
        throws DeckNotFoundException, DeckAlreadyFavoritedException, DeckNotFavoritedException {
        return favoriteAction(id, language, false);
    }

    private Deck favoriteAction(UUID id, String language, boolean makeFavorite)
        throws DeckNotFoundException, DeckAlreadyFavoritedException, DeckNotFavoritedException {
        DeckEntity deckEntity = this.readById(id);
        User connectedUser = userService.getConnectedUser();
        UserEntity userToSave = userMapper.toEntity(
            userService.saveUserIfNotExists(connectedUser)
        );
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
            deckEntity.setUsersFavorite(
                deckEntity
                    .getUsersFavorite()
                    .stream()
                    .filter(userEntity ->
                        !userEntity.getMail().equals(connectedUser.getMail())
                    )
                    .collect(Collectors.toSet())
            );
            deckEntity.setCountFavorites(deckEntity.getCountFavorites() - 1);
        }
        return deckMapper.toDto(
            deckRepository.save(deckEntity),
            CustomMapperContext.builder()
                .languageCode(language)
                .connectedUser(connectedUser)
                .minimizeData(true)
                .build()
        );
    }

    public void delete(UUID id)
        throws DeckOwnershipException, DeckNotFoundException {
        Optional<DeckEntity> deckEntity = deckRepository.findById(id);
        if (deckEntity.isEmpty()) {
            throw new DeckNotFoundException();
        }
        User user = userService.getConnectedUser();
        if (!deckEntity.get().getUser().getMail().equals(user.getMail())) {
            throw new DeckOwnershipException();
        }
        this.deckRepository.deleteById(id);
    }

    private DeckEntity readById(UUID id) throws DeckNotFoundException {
        Optional<DeckEntity> deckEntity = deckRepository.findById(id);
        if (deckEntity.isEmpty()) {
            throw new DeckNotFoundException();
        }
        return deckEntity.get();
    }

    private boolean isDeckValid(Deck deck) {
        if (
            deck.getLeader() == null ||
            deck.getLeader().getId() == null ||
            deck.getName() == null ||
            deck.getName().isEmpty()
        ) {
            return false;
        }
        Optional<CardEntity> leaderEntityOptional = cardRepository.findById(
            deck.getLeader().getId()
        );
        if (
            leaderEntityOptional.isEmpty() ||
            !leaderEntityOptional.get().getType().equals(Type.LEADER)
        ) {
            return false;
        }
        if (!validCardsNumbers(deck)) {
            return false;
        }
        return validCardsColors(deck, leaderEntityOptional.get());
    }

    private boolean validCardsNumbers(Deck deck) {
        if (
            deck.getCards() == null ||
            deck.getCards().size() != MAX_CARDS_IN_DECK ||
            deck
                .getCards()
                .stream()
                .anyMatch(card -> card == null || card.getId() == null)
        ) {
            return false;
        }
        Set<String> distinctIds = deck
            .getCards()
            .stream()
            .map(Card::getId)
            .collect(Collectors.toSet());
        return distinctIds
            .stream()
            .noneMatch(
                id ->
                    deck
                        .getCards()
                        .stream()
                        .filter(card -> card.getId().equals(id))
                        .count() >
                    MAX_COPIES_NUMBER_OF_CARD_PER_DECK
            );
    }

    private boolean validCardsColors(Deck deck, CardEntity leaderEntity) {
        List<CardEntity> cardEntities = cardRepository.findAllById(
            deck.getCards().stream().map(Card::getId).toList()
        );
        return cardEntities
            .stream()
            .allMatch(cardEntity ->
                hasCardColorOfLeader(
                    leaderEntity,
                    retrieveCardEntityFromListById(
                        cardEntities,
                        cardEntity.getId()
                    )
                )
            );
    }

    private CardEntity retrieveCardEntityFromListById(
        List<CardEntity> cardEntities,
        String id
    ) {
        return cardEntities
            .stream()
            .filter(cardEntity -> cardEntity.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    private boolean hasCardColorOfLeader(
        CardEntity leader,
        CardEntity cardSelected
    ) {
        return leader
            .getColors()
            .stream()
            .anyMatch(
                color ->
                    cardSelected != null &&
                    cardSelected.getColors().stream().anyMatch(color::equals)
            );
    }

    private void addMailToFilter(
        SpecificationBuilder<DeckEntity> builder,
        User userConnected,
        boolean onlyUserDeck
    ) {
        if (onlyUserDeck && userConnected != null) {
            builder.with(DeckSpecification.byUserMail(userConnected.getMail()));
        }
    }

    private void addKeywordToFilter(
        SpecificationBuilder<DeckEntity> builder,
        String keyword
    ) {
        if (keyword != null && !keyword.isEmpty()) {
            builder.with(DeckSpecification.byKeyword(keyword));
        }
    }

    private void addColorsToFilter(
        SpecificationBuilder<DeckEntity> builder,
        Set<Color> colors
    ) {
        if (colors != null && !colors.isEmpty()) {
            builder.with(DeckSpecification.byColor(colors));
        }
    }

    private void addOnlyFavoriteToFilter(
        SpecificationBuilder<DeckEntity> builder,
        User connectedUser,
        boolean onlyFavorite
    ) {
        if (
            connectedUser != null &&
            connectedUser.getMail() != null &&
            onlyFavorite
        ) {
            builder.with(
                DeckSpecification.byUserFavoriteDeck(connectedUser.getMail())
            );
        }
    }
}
