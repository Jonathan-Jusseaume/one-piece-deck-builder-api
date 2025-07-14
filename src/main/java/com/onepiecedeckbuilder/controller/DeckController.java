package com.onepiecedeckbuilder.controller;

import com.onepiecedeckbuilder.dto.Color;
import com.onepiecedeckbuilder.dto.Deck;
import com.onepiecedeckbuilder.dto.PaginationRequest;
import com.onepiecedeckbuilder.dto.PagingResultWithFilters;
import com.onepiecedeckbuilder.exceptions.*;
import com.onepiecedeckbuilder.repository.search.DeckSearch;
import com.onepiecedeckbuilder.service.DeckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.Set;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/decks")
@RequiredArgsConstructor
public class DeckController {

    private final DeckService deckService;

    @Operation(summary = "List decks matching filters")
    @GetMapping
    public PagingResultWithFilters<Deck, DeckSearch> list(
        @RequestParam(required = false, defaultValue = "0") @Parameter(
            name = "page",
            description = "The page number. Start from 0"
        ) Integer page,
        @RequestParam(required = false, defaultValue = "25") @Parameter(
            name = "size",
            description = "Size of the page"
        ) Integer size,
        @RequestParam(
            required = false,
            defaultValue = "countFavorites,creationDate"
        ) @Parameter(name = "sort", description = "Field to sort") String sort,
        @RequestParam(required = false, defaultValue = "DESC") @Parameter(
            name = "sort",
            description = "Direction of sort"
        ) Sort.Direction direction,
        @RequestParam(required = false, name = "color") @Parameter(
            name = "color",
            description = "Color Id of the leader of the deck. You can put multiple values"
        ) Set<Color> colors,
        @RequestParam(required = false) @Parameter(
            name = "keyword",
            description = "Keywords which are in the deck name or the deck description. You can prefix them with \"!\" " +
            "in order to search deck which don't have this word."
        ) String keyword,
        @RequestParam(required = false, defaultValue = "false") @Parameter(
            name = "onlyFavorite",
            description = "If the boolean value is true, it will return only favorite decks of user. You must be logged in, in" +
            "order to use this filter."
        ) Boolean onlyFavorite,
        @RequestParam(required = false, defaultValue = "false") @Parameter(
            name = "onlyUserDeck",
            description = "If the boolean value is true, it will return only the deck created by the user connected"
        ) Boolean onlyUserDeck
    ) throws UserUnauthorizedException {
        DeckSearch deckSearch = DeckSearch.builder()
            .onlyUserDeck(onlyUserDeck)
            .onlyFavorite(onlyFavorite)
            .colors(colors)
            .keyword(keyword)
            .pagination(
                PaginationRequest.builder()
                    .page(page)
                    .size(size)
                    .sort(sort)
                    .direction(direction)
                    .build()
            )
            .build();

        return deckService.list(
            deckSearch,
            LocaleContextHolder.getLocale().getLanguage()
        );
    }

    @Operation(
        summary = "Read the deck with the ID in the path",
        description = "Fetches a deck by its ID. Throws a DeckNotFoundException if the deck is not found.",
        responses = {
            @ApiResponse(
                description = "Successfully retrieved the deck",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Deck with the given ID not found",
                responseCode = "404",
                content = @Content(mediaType = "application/json")
            ),
        }
    )
    @GetMapping("{id}")
    public Deck read(
        @Parameter(description = "ID of the deck") @PathVariable UUID id
    ) throws DeckNotFoundException {
        return deckService.read(
            id,
            LocaleContextHolder.getLocale().getLanguage()
        );
    }

    @Operation(summary = "Create a deck for the User Authenticated")
    @PostMapping
    public Deck create(@RequestBody Deck deck)
        throws DeckInvalidException, UserUnauthorizedException {
        return deckService.create(
            deck,
            LocaleContextHolder.getLocale().getLanguage()
        );
    }

    @Operation(summary = "Make a deck as favorite for the User Authenticated")
    @PostMapping("{id}/favorite")
    public Deck favorite(
        @Parameter(description = "ID of the deck") @PathVariable UUID id
    )
        throws DeckNotFoundException, DeckAlreadyFavoritedException, DeckNotFavoritedException {
        return deckService.favorite(
            id,
            LocaleContextHolder.getLocale().getLanguage()
        );
    }

    @Operation(summary = "Unfavorite a deck for the User Authenticated")
    @PostMapping("{id}/unfavorite")
    public Deck unfavorite(
        @Parameter(description = "ID of the deck") @PathVariable UUID id
    )
        throws DeckNotFoundException, DeckAlreadyFavoritedException, DeckNotFavoritedException {
        return deckService.unfavorite(
            id,
            LocaleContextHolder.getLocale().getLanguage()
        );
    }

    @Operation(
        summary = "Delete the deck with the id in the path. You need to be the owner of the deck"
    )
    @DeleteMapping("{id}")
    public void delete(
        @Parameter(description = "ID of the deck") @PathVariable UUID id
    ) throws DeckOwnershipException, DeckNotFoundException {
        deckService.delete(id);
    }
}
