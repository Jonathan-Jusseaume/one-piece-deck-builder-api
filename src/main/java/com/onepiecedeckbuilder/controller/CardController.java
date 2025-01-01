package com.onepiecedeckbuilder.controller;

import com.onepiecedeckbuilder.dto.Card;
import com.onepiecedeckbuilder.dto.Color;
import com.onepiecedeckbuilder.dto.Rarity;
import com.onepiecedeckbuilder.dto.Type;
import com.onepiecedeckbuilder.service.CardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
@Tag(name = "cards", description = "Operations related to cards")
public class CardController {

    private final CardService cardService;

    @Operation(summary = "Get a page of the card list matching different criteria")
    @GetMapping
    public Page<Card> list(
            @PageableDefault(size = 25)
            @SortDefault(sort = "id", direction = Sort.Direction.ASC)
            Pageable pageable,
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
        return cardService.list(pageable,
                types,
                colors,
                tagsId,
                rarities,
                productsId,
                costs,
                powers,
                keyword,
                LocaleContextHolder.getLocale().getLanguage());
    }


}
