package com.onepiecedeckbuilder.dto;

import com.onepiecedeckbuilder.entity.CardDescriptionEntity;
import com.onepiecedeckbuilder.entity.CardEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Schema(description = "Represents a card with various attributes such as type, colors, tags, and effects.")
public class Card {
    @Schema(description = "Unique identifier for the card", example = "OP01-001")
    private String id;
    @Schema(description = "The type of the card", example = "LEADER")
    private Type type;
    @Schema(description = "List of colors associated with the card", example = "[\"RED\", \"BLUE\"]")
    private List<Color> colors;
    @Schema(description = "List of tags associated with the card")
    private List<Tag> tags;
    @Schema(description = "The attribute of the card, representing its main strength", example = "STRIKE")
    private Attribute attribute;
    @Schema(description = "The label or name of the card")
    private String label;
    @Schema(description = "Effect or description of the card's ability")
    private String effect;
    @Schema(description = "Cost to play the card", example = "5")
    private Integer cost;
    @Schema(description = "Power of the card", example = "3000")
    private Integer power;
    @Schema(description = "Life of the card", example = "5")
    private Integer life;
    @Schema(description = "Counter for the card", example = "1000")
    private Integer counter;
    @Schema(description = "List of images associated with the card")
    private List<CardImage> images;

    public Card(CardEntity cardEntity, String languageCode) {
        this.id = cardEntity.getId();
        this.type = cardEntity.getType();
        this.attribute = cardEntity.getAttribute();
        this.cost = cardEntity.getCost();
        this.counter = cardEntity.getCounter();
        this.life = cardEntity.getLife();
        this.images = cardEntity.getImages().stream().map(cardImageEntity -> new CardImage(cardImageEntity, languageCode))
                .sorted()
                .toList();
        this.power = cardEntity.getPower();
        this.colors = cardEntity.getColors();
        this.tags = cardEntity.getTags()
                .stream()
                .map(tagEntity -> new Tag(tagEntity, languageCode))
                .sorted()
                .toList();
        for (CardDescriptionEntity description : cardEntity.getDescriptions()) {
            if (description.getLanguageCode().equals(languageCode)) {
                this.label = description.getName();
                this.effect = description.getEffect();
            }
        }
    }

}
