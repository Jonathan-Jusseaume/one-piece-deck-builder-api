package com.onepiecedeckbuilder.entity;

import com.onepiecedeckbuilder.entity.key.TypeDescriptionKey;
import lombok.Getter;
import lombok.experimental.Accessors;

import jakarta.persistence.*;

@Getter
@Accessors(chain = true)
@Entity
@Table(name = "UT_TYPE_DESCRIPTION", schema = "public")
@IdClass(TypeDescriptionKey.class)
public class TypeDescriptionEntity {

    @Id
    @Column(name = "TYPE_ID", nullable = false)
    private Long typeId;

    @Id
    @Column(name = "LANGUAGE_CODE", nullable = false)
    private String languageCode;

    @Column(name = "NAME", nullable = false)
    private String name;

}
