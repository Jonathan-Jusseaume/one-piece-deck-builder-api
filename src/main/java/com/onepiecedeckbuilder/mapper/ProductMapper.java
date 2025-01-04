package com.onepiecedeckbuilder.mapper;

import com.onepiecedeckbuilder.dto.Product;
import com.onepiecedeckbuilder.dto.Tag;
import com.onepiecedeckbuilder.entity.ProductDescriptionEntity;
import com.onepiecedeckbuilder.entity.ProductEntity;
import com.onepiecedeckbuilder.entity.TagDescriptionEntity;
import com.onepiecedeckbuilder.entity.TagEntity;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DateMapper.class})
public interface ProductMapper {

    @Mapping(target = "label", source = "descriptions", qualifiedByName = "productLabelMatchingLanguage")
    @Mapping(target = "releaseDate", qualifiedByName = "instantToLocalDate")
    Product toDto(ProductEntity productEntity, @Context String languageCode);

    @Named("productLabelMatchingLanguage")
    default String getLabel(Set<ProductDescriptionEntity> descriptionEntities, @Context String languageCode) {
        return descriptionEntities.stream()
                .filter(description -> languageCode.equals(description.getLanguageCode()))
                .map(ProductDescriptionEntity::getName)
                .findFirst()
                .orElse(null);
    }

}
