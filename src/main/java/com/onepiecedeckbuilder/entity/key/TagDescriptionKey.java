package com.onepiecedeckbuilder.entity.key;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class TagDescriptionKey implements Serializable {

    private Long tagId;

    private String languageCode;
}
