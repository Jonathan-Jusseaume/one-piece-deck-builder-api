package com.onepiecedeckbuilder.entity;

import com.onepiecedeckbuilder.dto.Attribute;
import com.onepiecedeckbuilder.dto.Color;
import com.onepiecedeckbuilder.dto.Type;
import jakarta.persistence.*;
import java.util.List;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.annotations.BatchSize;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "UT_CARD", schema = "public")
public class CardEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "ATTRIBUTE")
    @Enumerated(EnumType.STRING)
    private Attribute attribute;

    @OneToMany
    @JoinColumn(name = "CARD_ID")
    @BatchSize(size = 25)
    private Set<CardDescriptionEntity> descriptions;

    @ElementCollection(targetClass = Color.class, fetch = FetchType.EAGER)
    @CollectionTable(
        name = "UT_CARD_COLOR",
        joinColumns = @JoinColumn(name = "CARD_ID")
    )
    @Column(name = "COLOR")
    @Enumerated(EnumType.STRING)
    @BatchSize(size = 25)
    private List<Color> colors;

    @ManyToMany
    @JoinTable(
        name = "UT_CARD_TAG",
        joinColumns = @JoinColumn(name = "CARD_ID"),
        inverseJoinColumns = @JoinColumn(name = "TAG_ID")
    )
    @BatchSize(size = 25)
    private Set<TagEntity> tags;

    @OneToMany
    @JoinColumn(name = "CARD_ID")
    @BatchSize(size = 25)
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
