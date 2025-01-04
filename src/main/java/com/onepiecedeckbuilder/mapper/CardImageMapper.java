package com.onepiecedeckbuilder.mapper;

import com.onepiecedeckbuilder.dto.CardImage;
import com.onepiecedeckbuilder.entity.CardImageEntity;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProductMapper.class})
public interface CardImageMapper {

    @Mapping(target = "filename", source = "name")
    CardImage toDto(CardImageEntity cardImageEntity, @Context String languageCode);

}
