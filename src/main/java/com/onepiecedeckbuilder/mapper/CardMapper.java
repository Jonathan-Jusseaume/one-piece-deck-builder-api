package com.onepiecedeckbuilder.mapper;

import com.onepiecedeckbuilder.dto.Card;
import com.onepiecedeckbuilder.dto.CardImage;
import com.onepiecedeckbuilder.dto.Tag;
import com.onepiecedeckbuilder.entity.CardDescriptionEntity;
import com.onepiecedeckbuilder.entity.CardEntity;
import com.onepiecedeckbuilder.mapper.context.CustomMapperContext;
import org.mapstruct.*;

import java.util.Comparator;
import java.util.Set;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {TagMapper.class, CardImageMapper.class})
public interface CardMapper {

    @Mapping(target = "label", source = "descriptions", qualifiedByName = "cardLabelMatchingLanguage")
    @Mapping(target = "effect", source = "descriptions", qualifiedByName = "cardEffectMatchingLanguage")
    Card toDto(CardEntity cardEntity, @Context CustomMapperContext mapperContext);

    @Named("cardLabelMatchingLanguage")
    default String getLabel(Set<CardDescriptionEntity> descriptionEntities, @Context CustomMapperContext mapperContext) {
        return descriptionEntities.stream()
                .filter(description -> mapperContext.getLanguageCode().equals(description.getLanguageCode()))
                .map(CardDescriptionEntity::getName)
                .findFirst()
                .orElse(null);
    }

    @Named("cardEffectMatchingLanguage")
    default String getEffect(Set<CardDescriptionEntity> descriptionEntities, @Context CustomMapperContext mapperContext) {
        return descriptionEntities.stream()
                .filter(description -> mapperContext.getLanguageCode().equals(description.getLanguageCode()))
                .findFirst()
                .orElse(new CardDescriptionEntity())
                .getEffect();
    }

    @AfterMapping
    default void sortFields(@MappingTarget Card card) {
        if (card.getTags() != null) {
            card.getTags().sort(Comparator.comparing(Tag::getLabel));
        }
        if (card.getImages() != null) {
            card.getImages().sort(Comparator.comparing(CardImage::getFilename));
        }
    }

}
