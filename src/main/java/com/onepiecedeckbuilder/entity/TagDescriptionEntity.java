package com.onepiecedeckbuilder.entity;

import com.onepiecedeckbuilder.entity.key.TagDescriptionKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
@Entity
@Table(name = "UT_TAG_DESCRIPTION", schema = "public")
@IdClass(TagDescriptionKey.class)
public class TagDescriptionEntity {

    @Id
    @Column(name = "TAG_ID", nullable = false)
    private Long tagId;

    @Id
    @Column(name = "LANGUAGE_CODE", nullable = false)
    private String languageCode;

    @Column(name = "NAME", nullable = false)
    private String name;

}
