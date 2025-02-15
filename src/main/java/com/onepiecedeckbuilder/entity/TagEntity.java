package com.onepiecedeckbuilder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.BatchSize;

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
    @BatchSize(size = 25)
    private Set<TagDescriptionEntity> descriptions;
}
