package com.onepiecedeckbuilder.mapper;

import com.onepiecedeckbuilder.dto.Deck;
import com.onepiecedeckbuilder.entity.DeckEntity;
import com.onepiecedeckbuilder.mapper.context.CustomMapperContext;
import org.mapstruct.*;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    uses = { CardMapper.class, DateMapper.class }
)
public interface DeckMapper {
    @Mapping(target = "creationDate", qualifiedByName = "instantToLocalDate")
    @Mapping(
        target = "favorite",
        source = ".",
        qualifiedByName = "fillFavoriteAccordingToConnectedUser"
    )
    Deck toDto(DeckEntity deckEntity, @Context CustomMapperContext context);

    @Named("fillFavoriteAccordingToConnectedUser")
    default boolean getIsFavoriteAccordingTonConnectedUser(
        DeckEntity deckEntity,
        @Context CustomMapperContext mapperContext
    ) {
        if (mapperContext.getConnectedUser() == null) {
            return false;
        }
        return deckEntity.isFavorite(
            mapperContext.getConnectedUser().getMail()
        );
    }

    @AfterMapping
    default void hideCardsWhenMinimizeData(
        @MappingTarget Deck deck,
        @Context CustomMapperContext context
    ) {
        if (Boolean.TRUE.equals(context.getMinimizeData())) {
            deck.setCards(null);
        }
    }
}
