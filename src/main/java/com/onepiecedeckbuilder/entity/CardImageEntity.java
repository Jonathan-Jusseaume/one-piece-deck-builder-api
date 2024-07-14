package com.onepiecedeckbuilder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "UT_CARD_IMAGE", schema = "public")
public class CardImageEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @OneToOne
    @JoinColumn(name = "RARITY_ID")
    private RarityEntity rarity;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity product;

}
