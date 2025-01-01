package com.onepiecedeckbuilder.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "An enumeration of different card rarities")
public enum Rarity {
    L,
    C,
    UC,
    R,
    SR,
    SEC,
    SP_CARD,
    P
}
