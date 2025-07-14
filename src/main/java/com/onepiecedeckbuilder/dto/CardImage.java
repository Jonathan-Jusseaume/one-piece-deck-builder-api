package com.onepiecedeckbuilder.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@EqualsAndHashCode
@Schema(description = "Represents a specific illustration of a card")
public class CardImage {

    @Schema(
        description = "Name of the illustration of the card",
        example = "OP01-001.png"
    )
    private String filename;

    @Schema(
        description = "Rarity of this illustration of the card",
        example = "SEC"
    )
    private Rarity rarity;

    @Schema(description = "Product where you can find this version of the card")
    private Product product;
}
