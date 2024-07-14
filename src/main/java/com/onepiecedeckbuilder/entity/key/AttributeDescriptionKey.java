package com.onepiecedeckbuilder.entity.key;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
public class AttributeDescriptionKey implements Serializable {

    private Long attributeId;

    private String languageCode;
}
