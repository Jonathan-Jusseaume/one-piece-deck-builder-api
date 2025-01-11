package com.onepiecedeckbuilder.mapper.context;

import com.onepiecedeckbuilder.dto.User;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class CustomMapperContext {
    private String languageCode;
    private User connectedUser;
    private Boolean minimizeData;
}
