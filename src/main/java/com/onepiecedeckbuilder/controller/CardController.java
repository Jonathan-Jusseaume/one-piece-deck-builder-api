package com.onepiecedeckbuilder.controller;

import com.onepiecedeckbuilder.dto.*;
import com.onepiecedeckbuilder.repository.search.CardSearch;
import com.onepiecedeckbuilder.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
@Tag(name = "cards", description = "Operations related to cards")
public class CardController {

    private final CardService cardService;

    @Operation(summary = "Get a page of the card list matching different criteria")
    @GetMapping
    public PagingResultWithFilters<Card, CardSearch> list(
            @RequestParam(required = false, defaultValue = "0")
            @Parameter(name = "page", description = "The page number. Start from 0")
            Integer page,
            @RequestParam(required = false, defaultValue = "25")
            @Parameter(name = "size", description = "Size of the page")
            Integer size,
            @RequestParam(required = false, defaultValue = "id")
            @Parameter(name = "sort", description = "Field to sort")
            String sort,
            @RequestParam(required = false, defaultValue = "DESC")
            @Parameter(name = "sort", description = "Direction of sort")
            Sort.Direction direction,
            @RequestParam(required = false, name = "type")
            @Parameter(name = "type",
                    description = "Type of the card. You can put multiple values")
            Set<Type> types,
            @RequestParam(required = false, name = "color")
            @Parameter(name = "color",
                    description = "Color of the card. You can put multiple values")
            Set<Color> colors,
            @RequestParam(required = false, name = "tagId")
            @Parameter(name = "tagId",
                    description = "Tag Id of the card. You can put multiple values")
            Set<Long> tagsId,
            @RequestParam(required = false, name = "rarity")
            @Parameter(name = "rarity",
                    description = "Rarity Id of the card. You can put multiple values")
            Set<Rarity> rarities,
            @RequestParam(required = false, name = "productId")
            @Parameter(name = "productId",
                    description = "Product Id of the card. You can put multiple values")
            Set<String> productsId,
            @RequestParam(required = false, name = "cost")
            @Parameter(name = "costs",
                    description = "Cost value of the card. You can put multiple values")
            Set<Integer> costs,
            @RequestParam(required = false, name = "power")
            @Parameter(name = "power",
                    description = "Power value of the card. You can put multiple values")
            Set<Integer> powers,
            @RequestParam(required = false)
            @Parameter(name = "keyword",
                    description = "Keywords which are in the card name or the card description. You can prefix them with \"!\" " +
                            "in order to search cards which don't have this word.")
            String keyword) {
        CardSearch cardSearch = CardSearch.builder()
                .pagination(PaginationRequest.builder()
                        .page(page)
                        .size(size)
                        .sort(sort)
                        .direction(direction)
                        .build())
                .colors(colors)
                .keyword(keyword)
                .types(types)
                .tagsId(tagsId)
                .rarities(rarities)
                .productsId(productsId)
                .costs(costs)
                .powers(powers)
                .build();

        return cardService.list(
                cardSearch,
                LocaleContextHolder.getLocale().getLanguage()
        );
    }


}
