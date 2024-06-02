package com.opcgdb_api.entity;

import lombok.Getter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Set;

@Getter
@Accessors(chain = true)
@Entity
@Table(name = "UT_TYPE", schema = "public")
public class TypeEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_ID")
    private Set<TypeDescriptionEntity> descriptions;

}
