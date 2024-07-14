package com.onepiecedeckbuilder.entity;

import com.onepiecedeckbuilder.entity.key.AttributeDescriptionKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "UT_ATTRIBUTE_DESCRIPTION", schema = "public")
@IdClass(AttributeDescriptionKey.class)
public class AttributeDescriptionEntity {

    @Id
    @Column(name = "ATTRIBUTE_ID", nullable = false)
    private Long attributeId;

    @Id
    @Column(name = "LANGUAGE_CODE", nullable = false)
    private String languageCode;

    @Column(name = "NAME", nullable = false)
    private String name;

}
