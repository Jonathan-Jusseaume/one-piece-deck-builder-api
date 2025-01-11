package com.onepiecedeckbuilder.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DateMapper {

    @Named("instantToLocalDate")
    default LocalDate instantToLocalDate(Instant instant) {
        return LocalDate.ofInstant(instant, ZoneOffset.UTC);
    }

    @Named("localDateToInstant")
    default Instant localDateToInstant(LocalDate date) {
        return date != null ? date.atStartOfDay().toInstant(ZoneOffset.UTC) : null;
    }
}
