package com.onepiecedeckbuilder.entity;

import lombok.Getter;
import lombok.experimental.Accessors;

import jakarta.persistence.*;
import java.util.Set;

@Getter
@Accessors(chain = true)
@Entity
@Table(name = "UT_TYPE", schema = "public")
public class TypeEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "TYPE_ID")
    private Set<TypeDescriptionEntity> descriptions;

}
