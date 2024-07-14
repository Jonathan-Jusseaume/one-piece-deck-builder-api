package com.onepiecedeckbuilder.dto;

import com.onepiecedeckbuilder.entity.ColorDescriptionEntity;
import com.onepiecedeckbuilder.entity.ColorEntity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@EqualsAndHashCode
public class Color {

    private Long id;

    private String label;

    public Color(ColorEntity colorEntity, String languageCode) {
        this.setId(colorEntity.getId());
        this.setLabel(colorEntity.getDescriptions()
                .stream()
                .filter(description -> description.getLanguageCode().equals(languageCode))
                .map(ColorDescriptionEntity::getName)
                .findFirst()
                .orElse(""));
    }
}
