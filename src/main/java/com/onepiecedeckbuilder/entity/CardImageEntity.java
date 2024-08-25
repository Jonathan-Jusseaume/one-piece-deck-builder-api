package com.onepiecedeckbuilder.entity;

import com.onepiecedeckbuilder.dto.Rarity;
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

    @Column(name = "RARITY")
    @Enumerated(EnumType.STRING)
    private Rarity rarity;

    @OneToOne
    @JoinColumn(name = "PRODUCT_ID")
    private ProductEntity product;

}
