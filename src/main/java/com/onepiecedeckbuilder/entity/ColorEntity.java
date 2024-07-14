package com.onepiecedeckbuilder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Set;

@Getter
@Accessors(chain = true)
@Entity
@Table(name = "UT_COLOR", schema = "public")
public class ColorEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "COLOR_ID")
    private Set<ColorDescriptionEntity> descriptions;

}
