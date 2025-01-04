package com.onepiecedeckbuilder.mapper.context;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class CustomMapperContext {
    private String languageCode;
    private String connectedUser;
    private Boolean minimizeData = false;
}
