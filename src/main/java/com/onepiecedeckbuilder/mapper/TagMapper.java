package com.onepiecedeckbuilder.mapper;

import com.onepiecedeckbuilder.dto.Tag;
import com.onepiecedeckbuilder.entity.TagDescriptionEntity;
import com.onepiecedeckbuilder.entity.TagEntity;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagMapper {

    @Mapping(target = "label", source = "descriptions", qualifiedByName = "tagLabelMatchingLanguage")
    Tag toDto(TagEntity tagEntity, @Context String languageCode);

    @Named("tagLabelMatchingLanguage")
    default String getLabel(Set<TagDescriptionEntity> descriptionEntities, @Context String languageCode) {
        return descriptionEntities.stream()
                .filter(description -> languageCode.equals(description.getLanguageCode()))
                .map(TagDescriptionEntity::getName)
                .findFirst()
                .orElse(null);
    }

}
