package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Card;
import com.onepiecedeckbuilder.entity.CardEntity;
import com.onepiecedeckbuilder.repository.CardDao;
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

    private final CardDao cardDao;

    public Page<Card> list(Pageable pageable,
                           Set<Long> typesId,
                           Set<Long> colorsId,
                           Set<Long> tagsId,
                           Set<Long> raritiesId,
                           Set<String> productsId,
                           Set<Integer> costs,
                           Set<Integer> powers,
                           String keyword,
                           String languageCode) {
        pageable = pageable != null ? pageable : Pageable.ofSize(25);

        SpecificationBuilder<CardEntity> builder = new SpecificationBuilder<>();
        builder.with(CardSpecification.distinct());

        addToFilter(builder, typesId, CardSpecification::byTypeId);
        addToFilter(builder, colorsId, CardSpecification::byColorId);
        addToFilter(builder, tagsId, CardSpecification::byTagId);
        addToFilter(builder, raritiesId, CardSpecification::byRarity);
        addToFilter(builder, productsId, CardSpecification::byProductId);
        addToFilter(builder, costs, CardSpecification::byCost);
        addToFilter(builder, powers, CardSpecification::byPower);
        addKeywordToFilter(builder, keyword);

        Page<CardEntity> results = cardDao.findAll(builder.build(), pageable);
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
