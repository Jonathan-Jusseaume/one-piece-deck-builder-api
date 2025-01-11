package com.onepiecedeckbuilder.mapper;

import com.onepiecedeckbuilder.dto.User;
import com.onepiecedeckbuilder.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DateMapper.class})
public interface UserMapper {

    @Mapping(target = "creationDate", source = "joinDate",  qualifiedByName = "instantToLocalDate")
    User toDto(UserEntity userEntity);

    @Mapping(target = "joinDate", source = "creationDate", qualifiedByName = "localDateToInstant")
    UserEntity toEntity(User user);

}
