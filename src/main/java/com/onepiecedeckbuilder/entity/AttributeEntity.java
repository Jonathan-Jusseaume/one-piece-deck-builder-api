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
@Table(name = "UT_ATTRIBUTE", schema = "public")
public class AttributeEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "ATTRIBUTE_ID")
    private Set<AttributeDescriptionEntity> descriptions;

}
