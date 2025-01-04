package com.onepiecedeckbuilder.mapper;

import com.onepiecedeckbuilder.dto.Product;
import com.onepiecedeckbuilder.entity.ProductDescriptionEntity;
import com.onepiecedeckbuilder.entity.ProductEntity;
import com.onepiecedeckbuilder.mapper.context.CustomMapperContext;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DateMapper.class})
public interface ProductMapper {

    @Mapping(target = "label", source = "descriptions", qualifiedByName = "productLabelMatchingLanguage")
    @Mapping(target = "releaseDate", qualifiedByName = "instantToLocalDate")
    Product toDto(ProductEntity productEntity, @Context CustomMapperContext customMapperContext);

    @Named("productLabelMatchingLanguage")
    default String getLabel(Set<ProductDescriptionEntity> descriptionEntities, @Context CustomMapperContext customMapperContext) {
        return descriptionEntities.stream()
                .filter(description -> customMapperContext.getLanguageCode().equals(description.getLanguageCode()))
                .map(ProductDescriptionEntity::getName)
                .findFirst()
                .orElse(null);
    }

}
