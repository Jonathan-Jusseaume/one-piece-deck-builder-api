package com.onepiecedeckbuilder.mapper;

import com.onepiecedeckbuilder.dto.Card;
import com.onepiecedeckbuilder.entity.CardDescriptionEntity;
import com.onepiecedeckbuilder.entity.CardEntity;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {TagMapper.class, CardImageMapper.class})
public interface CardMapper {

    @Mapping(target = "label", source = "descriptions", qualifiedByName = "cardLabelMatchingLanguage")
    @Mapping(target = "effect", source = "descriptions", qualifiedByName = "cardEffectMatchingLanguage")
    Card toDto(CardEntity cardEntity, @Context String languageCode);

    @Named("cardLabelMatchingLanguage")
    default String getLabel(Set<CardDescriptionEntity> descriptionEntities, @Context String languageCode) {
        return descriptionEntities.stream()
                .filter(description -> languageCode.equals(description.getLanguageCode()))
                .map(CardDescriptionEntity::getName)
                .findFirst()
                .orElse(null);
    }

    @Named("cardEffectMatchingLanguage")
    default String getEffect(Set<CardDescriptionEntity> descriptionEntities, @Context String languageCode) {
        return descriptionEntities.stream()
                .filter(description -> languageCode.equals(description.getLanguageCode()))
                .findFirst()
                .orElse(new CardDescriptionEntity())
                .getEffect();
    }

}
