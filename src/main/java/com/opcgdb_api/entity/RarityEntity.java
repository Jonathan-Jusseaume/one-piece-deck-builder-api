package com.opcgdb_api.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
