package com.onepiecedeckbuilder.mapper;

import com.onepiecedeckbuilder.dto.Tag;
import com.onepiecedeckbuilder.entity.TagDescriptionEntity;
import com.onepiecedeckbuilder.entity.TagEntity;
import com.onepiecedeckbuilder.mapper.context.CustomMapperContext;
import java.util.Set;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagMapper {
    @Mapping(
        target = "label",
        source = "descriptions",
        qualifiedByName = "tagLabelMatchingLanguage"
    )
    Tag toDto(
        TagEntity tagEntity,
        @Context CustomMapperContext customMapperContext
    );

    @Named("tagLabelMatchingLanguage")
    default String getLabel(
        Set<TagDescriptionEntity> descriptionEntities,
        @Context CustomMapperContext customMapperContext
    ) {
        return descriptionEntities
            .stream()
            .filter(description ->
                customMapperContext
                    .getLanguageCode()
                    .equals(description.getLanguageCode())
            )
            .map(TagDescriptionEntity::getName)
            .findFirst()
            .orElse(null);
    }
}
