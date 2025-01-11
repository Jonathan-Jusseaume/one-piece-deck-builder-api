package com.onepiecedeckbuilder.repository.search;

import com.onepiecedeckbuilder.dto.Color;
import com.onepiecedeckbuilder.dto.Rarity;
import com.onepiecedeckbuilder.dto.Type;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.domain.Pageable;

import java.util.Set;

@SuperBuilder
@Getter
public class CardSearch {
    private Pageable pageable;
    private Set<Color> colors;
    private String keyword;
    private Set<Type> types;
    private Set<Long> tagsId;
    private Set<Rarity> rarities;
    private Set<String> productsId;
    private Set<Integer> costs;
    private Set<Integer> powers;
}
