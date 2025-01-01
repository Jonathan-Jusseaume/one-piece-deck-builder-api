package com.onepiecedeckbuilder.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "An enumeration of different card types")
public enum Type {
    LEADER,
    CHARACTER,
    STAGE,
    EVENT
}
