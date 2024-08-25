package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Card;
import com.onepiecedeckbuilder.dto.Color;
import com.onepiecedeckbuilder.dto.Rarity;
import com.onepiecedeckbuilder.dto.Type;
import com.onepiecedeckbuilder.entity.CardEntity;
import com.onepiecedeckbuilder.repository.CardRepository;
import com.onepiecedeckbuilder.repository.specification.CardSpecification;
import com.onepiecedeckbuilder.repository.specification.SpecificationBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
@Transactional
public class CardService {

    private final CardRepository cardRepository;

    public Page<Card> list(Pageable pageable,
                           Set<Type> types,
                           Set<Color> colors,
                           Set<Long> tagsId,
                           Set<Rarity> rarities,
                           Set<String> productsId,
                           Set<Integer> costs,
                           Set<Integer> powers,
                           String keyword,
                           String languageCode) {
        pageable = pageable != null ? pageable : Pageable.ofSize(25);

        SpecificationBuilder<CardEntity> builder = new SpecificationBuilder<>();
        builder.with(CardSpecification.distinct());

        addToFilter(builder, types, CardSpecification::byType);
        addToFilter(builder, colors, CardSpecification::byColor);
        addToFilter(builder, tagsId, CardSpecification::byTagId);
        addToFilter(builder, rarities, CardSpecification::byRarity);
        addToFilter(builder, productsId, CardSpecification::byProductId);
        addToFilter(builder, costs, CardSpecification::byCost);
        addToFilter(builder, powers, CardSpecification::byPower);
        addKeywordToFilter(builder, keyword);

        Page<CardEntity> results = cardRepository.findAll(builder.build(), pageable);
        List<Card> cards = results.getContent()
                .stream()
                .map(cardEntity -> new Card(cardEntity, languageCode))
                .toList();

        return new PageImpl<>(cards, pageable, results.getTotalElements());
    }

    private <T> void addToFilter(SpecificationBuilder<CardEntity> builder, Set<T> criteria, Function<Set<T>, Specification<CardEntity>> specFunction) {
        if (criteria != null && !criteria.isEmpty()) {
            builder.with(specFunction.apply(criteria));
        }
    }

    private void addKeywordToFilter(SpecificationBuilder<CardEntity> builder, String keyword) {
        if (keyword != null && !keyword.isEmpty()) {
            builder.with(CardSpecification.byKeyword(keyword));
        }
    }
}
