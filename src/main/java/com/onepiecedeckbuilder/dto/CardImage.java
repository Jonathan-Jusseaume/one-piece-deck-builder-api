package com.onepiecedeckbuilder.dto;

import com.onepiecedeckbuilder.entity.CardImageEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@EqualsAndHashCode
public class CardImage implements Comparable<CardImage> {

    private String filename;

    private Rarity rarity;

    private Product product;

    public CardImage(CardImageEntity cardImageEntity, String languageCode) {
        this.filename = cardImageEntity.getName();
        this.rarity = cardImageEntity.getRarity();
        this.product = new Product(cardImageEntity.getProduct(), languageCode);
    }

    @Override
    public int compareTo(CardImage o) {
        return this.getFilename().compareTo(o.getFilename());
    }
}
