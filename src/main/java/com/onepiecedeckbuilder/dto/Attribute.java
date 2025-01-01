package com.onepiecedeckbuilder.dto;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(description = "An enumeration of different card attributes")
public enum Attribute {
    STRIKE,
    RANGED,
    SPECIAL,
    WISDOM,
    SLASH
}
