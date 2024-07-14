package com.onepiecedeckbuilder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "UT_RARITY", schema = "public")
public class RarityEntity {

    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "LABEL")
    private String label;

}
