package com.onepiecedeckbuilder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "UT_CARD", schema = "public")
public class CardEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @OneToOne
    @JoinColumn(name = "TYPE_ID")
    private TypeEntity type;

    @OneToOne
    @JoinColumn(name = "ATTRIBUTE_ID")
    private AttributeEntity attribute;

    @OneToMany
    @JoinColumn(name = "CARD_ID")
    private Set<CardDescriptionEntity> descriptions;

    @ManyToMany
    @JoinTable(name = "UT_CARD_COLOR",
            joinColumns = @JoinColumn(name = "CARD_ID"),
            inverseJoinColumns = @JoinColumn(name = "COLOR_ID")
    )
    private Set<ColorEntity> colors;

    @ManyToMany
    @JoinTable(name = "UT_CARD_TAG",
            joinColumns = @JoinColumn(name = "CARD_ID"),
            inverseJoinColumns = @JoinColumn(name = "TAG_ID")
    )
    private Set<TagEntity> tags;

    @OneToMany
    @JoinColumn(name = "CARD_ID")
    private Set<CardImageEntity> images;

    @Column(name = "COST")
    private Integer cost;

    @Column(name = "POWER")
    private Integer power;

    @Column(name = "LIFE")
    private Integer life;

    @Column(name = "COUNTER")
    private Integer counter;

}
