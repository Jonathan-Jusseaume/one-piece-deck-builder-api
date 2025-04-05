package com.onepiecedeckbuilder.repository.search;

import com.onepiecedeckbuilder.dto.Color;
import com.onepiecedeckbuilder.dto.PaginationRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@SuperBuilder
@Getter
@NoArgsConstructor
@Setter
public class DeckSearch {
    private PaginationRequest pagination;
    private Set<Color> colors;
    private String keyword;
    private Boolean onlyFavorite;
    private Boolean onlyUserDeck;
}
