package com.onepiecedeckbuilder.entity.key;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
public class ColorDescriptionKey implements Serializable {

    private Long colorId;

    private String languageCode;
}
