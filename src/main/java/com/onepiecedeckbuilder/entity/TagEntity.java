package com.onepiecedeckbuilder.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Getter
@Entity
@Table(name = "UT_TAG", schema = "public")
public class TagEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "TAG_ID")
    private Set<TagDescriptionEntity> descriptions;
}
