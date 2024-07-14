package com.onepiecedeckbuilder.dto;

import com.onepiecedeckbuilder.entity.TypeDescriptionEntity;
import com.onepiecedeckbuilder.entity.TypeEntity;
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
public class Type {

    private Long id;

    private String label;

    public Type(TypeEntity typeEntity, String languageCode) {
        this.id = typeEntity.getId();
        for (TypeDescriptionEntity description : typeEntity.getDescriptions()) {
            if (description.getLanguageCode().equals(languageCode)) {
                this.label = description.getName();
                break;
            }
        }
    }
}
