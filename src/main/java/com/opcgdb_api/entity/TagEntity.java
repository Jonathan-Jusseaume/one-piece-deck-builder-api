package com.opcgdb_api.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Entity
@Table(name = "UT_TAG", schema = "public")
public class TagEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "TAG_ID")
    private Set<TagDescriptionEntity> descriptions;
}
