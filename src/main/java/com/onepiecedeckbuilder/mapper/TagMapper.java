package com.onepiecedeckbuilder.mapper;

import com.onepiecedeckbuilder.dto.Tag;
import com.onepiecedeckbuilder.entity.TagDescriptionEntity;
import com.onepiecedeckbuilder.entity.TagEntity;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagMapper {

    @Mapping(target = "label", source = "descriptions", qualifiedByName = "labelMatchingLanguage")
    Tag toDto(TagEntity tagEntity, @Context String languageCode);

    @Named("labelMatchingLanguage")
    default String getLabel(Set<TagDescriptionEntity> descriptionEntities, @Context String languageCode) {
        if (descriptionEntities == null || languageCode == null) {
            return null;
        }
        return descriptionEntities.stream()
                .filter(description -> languageCode.equals(description.getLanguageCode()))
                .map(TagDescriptionEntity::getName)
                .findFirst()
                .orElse(null);
    }

}
