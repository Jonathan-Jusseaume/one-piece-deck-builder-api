package com.onepiecedeckbuilder.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.onepiecedeckbuilder.entity.CardEntity;
import com.onepiecedeckbuilder.entity.DeckEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class Deck {

    private UUID id;

    private List<Card> cards;

    private Card leader;

    private String name;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private LocalDate creationDate;

    private Integer countFavorites = 0;

    private Boolean favorite = false;

    @JsonIgnore
    private User user;

    public Deck(DeckEntity deckEntity, String languageCode, String mail, boolean withCards) {
        this.id = deckEntity.getId();
        if (withCards) {
            this.cards = deckEntity.getCards().stream()
                    .map(cardEntity -> new Card(cardEntity, languageCode))
                    .toList();
        }
        this.leader = new Card(deckEntity.getLeader(), languageCode);
        this.name = deckEntity.getName();
        this.creationDate = LocalDate.ofInstant(deckEntity.getCreationDate(), ZoneOffset.UTC);
        this.description = deckEntity.getDescription();
        this.countFavorites = deckEntity.getCountFavorites();
        this.favorite = deckEntity.isFavorite(mail);
    }

    public DeckEntity toEntity() {
        return new DeckEntity()
                .setId(id)
                .setUser(user.toEntity())
                .setCards(cards.stream()
                        .map(card -> new CardEntity()
                                .setId(card.getId()))
                        .toList())
                .setLeader(new CardEntity().setId(leader.getId()))
                .setDescription(description)
                .setName(name)
                .setCreationDate(creationDate.atStartOfDay().toInstant(ZoneOffset.UTC))
                .setUsersFavorite(Collections.emptySet())
                .setCountFavorites(countFavorites);
    }
}
