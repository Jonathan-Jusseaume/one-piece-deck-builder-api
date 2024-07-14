package com.onepiecedeckbuilder.entity;

import com.onepiecedeckbuilder.entity.key.ColorDescriptionKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
@Entity
@Table(name = "UT_COLOR_DESCRIPTION", schema = "public")
@IdClass(ColorDescriptionKey.class)
public class ColorDescriptionEntity {

    @Id
    @Column(name = "COLOR_ID", nullable = false)
    private Long colorId;

    @Id
    @Column(name = "language_code", nullable = false)
    private String languageCode;

    @Column(name = "name", nullable = false)
    private String name;

}
