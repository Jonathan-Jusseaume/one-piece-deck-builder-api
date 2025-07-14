package com.onepiecedeckbuilder.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.onepiecedeckbuilder.entity.CardEntity;
import com.onepiecedeckbuilder.entity.DeckEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Schema(
    description = "A class representing a deck of cards. A deck belongs to a user"
)
@ToString
public class Deck {

    @Schema(
        description = "Unique identifier for the deck",
        example = "550e8400-e29b-41d4-a716-446655440000"
    )
    private UUID id;

    @Schema(description = "List of cards in the deck")
    private List<Card> cards;

    @Schema(description = "Leader card in the deck")
    private Card leader;

    @Schema(description = "Name of the deck", example = "My Deck")
    private String name;

    @Schema(
        description = "Description of the deck",
        example = "This is my custom deck."
    )
    private String description;

    @Schema(description = "Creation date of the deck", example = "2023-01-01")
    @JsonFormat(
        shape = JsonFormat.Shape.STRING,
        pattern = "yyyy-MM-dd",
        timezone = "UTC"
    )
    private LocalDate creationDate;

    @Schema(
        description = "Number of times the deck has been marked as favorite",
        example = "10"
    )
    private Integer countFavorites = 0;

    @Schema(
        description = "Indicates if the deck is a favorite for the user who made the request",
        example = "true"
    )
    private Boolean favorite = false;

    public DeckEntity toEntity() {
        return new DeckEntity()
            .setId(id)
            .setCards(
                cards
                    .stream()
                    .map(card -> new CardEntity().setId(card.getId()))
                    .toList()
            )
            .setLeader(new CardEntity().setId(leader.getId()))
            .setDescription(description)
            .setName(name)
            .setCreationDate(
                creationDate.atStartOfDay().toInstant(ZoneOffset.UTC)
            )
            .setUsersFavorite(Collections.emptySet())
            .setCountFavorites(countFavorites);
    }
}
