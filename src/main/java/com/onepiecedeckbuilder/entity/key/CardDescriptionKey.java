package com.onepiecedeckbuilder.entity.key;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class CardDescriptionKey implements Serializable {

    private String cardId;

    private String languageCode;
}
