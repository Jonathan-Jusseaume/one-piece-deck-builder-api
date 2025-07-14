package com.onepiecedeckbuilder.entity.key;

import java.io.Serializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
public class ProductDescriptionKey implements Serializable {

    private String productId;

    private String languageCode;
}
