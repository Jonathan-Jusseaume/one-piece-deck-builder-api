package com.onepiecedeckbuilder.mapper.context;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CustomMapperContext {
    private String languageCode;
    private String connectedUser;
    private Boolean minimizeData = false;
}
