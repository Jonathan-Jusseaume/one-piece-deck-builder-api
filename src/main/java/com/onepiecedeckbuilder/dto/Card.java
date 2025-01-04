package com.onepiecedeckbuilder.dto;

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
    @Schema(description = "Effect or description of the card's ability", nullable = true)
    private String effect;
    @Schema(description = "Cost to play the card", example = "5", nullable = true)
    private Integer cost;
    @Schema(description = "Power of the card", example = "3000", nullable = true)
    private Integer power;
    @Schema(description = "Life of the card", example = "5", nullable = true)
    private Integer life;
    @Schema(description = "Counter for the card", example = "1000", nullable = true)
    private Integer counter;
    @Schema(description = "List of images associated with the card")
    private List<CardImage> images;

}
