package com.onepiecedeckbuilder.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "UT_PRODUCT", schema = "public")
public class ProductEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "RELEASE_DATE")
    private Instant releaseDate;

    @OneToMany
    @JoinColumn(name = "PRODUCT_ID")
    private Set<ProductDescriptionEntity> descriptions;

}
