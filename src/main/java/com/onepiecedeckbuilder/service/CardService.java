package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Card;
import com.onepiecedeckbuilder.dto.PagingResultWithFilters;
import com.onepiecedeckbuilder.entity.CardEntity;
import com.onepiecedeckbuilder.mapper.CardMapper;
import com.onepiecedeckbuilder.mapper.PaginationMapper;
import com.onepiecedeckbuilder.mapper.context.CustomMapperContext;
import com.onepiecedeckbuilder.repository.CardRepository;
import com.onepiecedeckbuilder.repository.search.CardSearch;
import com.onepiecedeckbuilder.repository.specification.CardSpecification;
import com.onepiecedeckbuilder.repository.specification.SpecificationBuilder;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    private final CardMapper cardMapper;

    private final PaginationMapper paginationMapper;

    public PagingResultWithFilters<Card, CardSearch> list(CardSearch cardSearch,
                                                          String languageCode) {
        Page<CardEntity> results = cardRepository.findAll(
                convertCardSearchToSpecification(cardSearch),
                paginationMapper.getPageable(cardSearch.getPagination())
        );

        List<Card> cards = results.getContent()
                .stream()
                .map(cardEntity -> cardMapper.toDto(cardEntity, CustomMapperContext
                        .builder()
                        .languageCode(languageCode)
                        .build()))
                .toList();
        
        return new PagingResultWithFilters<>(cards,
                results.getTotalPages(),
                results.getTotalElements(),
                results.getSize(),
                results.getNumber(),
                results.isEmpty(),
                cardSearch);
    }

    private Specification<CardEntity> convertCardSearchToSpecification(CardSearch cardSearch) {
        SpecificationBuilder<CardEntity> builder = new SpecificationBuilder<>();
        builder.with(CardSpecification.distinct());

        addToFilter(builder, cardSearch.getTypes(), CardSpecification::byType);
        addToFilter(builder, cardSearch.getColors(), CardSpecification::byColor);
        addToFilter(builder, cardSearch.getTagsId(), CardSpecification::byTagId);
        addToFilter(builder, cardSearch.getRarities(), CardSpecification::byRarity);
        addToFilter(builder, cardSearch.getProductsId(), CardSpecification::byProductId);
        addToFilter(builder, cardSearch.getCosts(), CardSpecification::byCost);
        addToFilter(builder, cardSearch.getPowers(), CardSpecification::byPower);
        addKeywordToFilter(builder, cardSearch.getKeyword());
        return builder.build();
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
