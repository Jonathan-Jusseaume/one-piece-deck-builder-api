package com.onepiecedeckbuilder.repository.search;

import com.onepiecedeckbuilder.dto.Color;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Pageable;

import java.util.Set;

@SuperBuilder
@Getter
public class DeckSearch {
    private Pageable pageable;
    private Set<Color> colors;
    private String keyword;
    private Boolean onlyFavorite;
    private Boolean onlyUserDeck;
}
