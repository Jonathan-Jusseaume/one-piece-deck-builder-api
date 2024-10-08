package com.onepiecedeckbuilder.controller;

import com.onepiecedeckbuilder.dto.Deck;
import com.onepiecedeckbuilder.dto.User;
import com.onepiecedeckbuilder.exceptions.*;
import com.onepiecedeckbuilder.service.DeckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/decks")
@RequiredArgsConstructor
public class DeckController {

    private final DeckService deckService;

    @Operation(summary = "List decks matching filters")
    @GetMapping
    public Page<Deck> list(
            @PageableDefault(size = 25)
            @SortDefault(sort = {"countFavorites", "creationDate"}, direction = Sort.Direction.DESC)
            Pageable pageable,
            @RequestParam(required = false, name = "colorId")
            @Parameter(name = "colorId",
                    description = "Color Id of the leader of the deck. You can put multiple values")
            Set<Long> colorsId,
            @RequestParam(required = false)
            @Parameter(name = "keyword",
                    description = "Keywords which are in the deck name or the deck description. You can prefix them with \"!\" " +
                            "in order to search deck which don't have this word.")
            String keyword,
            @RequestParam(required = false, defaultValue = "false")
            @Parameter(name = "onlyFavorite",
                    description = "If the boolean value is true, it will return only favorite decks of user. You must be logged in, in" +
                            "order to use this filter.")
            Boolean onlyFavorite,
            @RequestParam(required = false, defaultValue = "false")
            @Parameter(name = "onlyUserDeck",
                    description = "If the boolean value is true, it will return only the deck created by the user connected")
            Boolean onlyUserDeck) throws UserUnauthorizedException {
        User connectedUser = getConnectedUser();
        return deckService.list(
                pageable, onlyUserDeck, colorsId, keyword, connectedUser, onlyFavorite,
                LocaleContextHolder.getLocale().getLanguage()
        );
    }

    @Operation(summary = "Read the deck with the ID in the path")
    @GetMapping("{id}")
    public Deck read(
            @Parameter(description = "ID of the deck")
            @PathVariable UUID id) throws DeckNotFoundException {
        User connectedUser = getConnectedUser();
        return deckService.read(id, LocaleContextHolder.getLocale().getLanguage(),
                connectedUser != null ? connectedUser.getMail() : "");
    }


    @Operation(summary = "Create a deck for the User Authenticated")
    @PostMapping
    public Deck create(@RequestBody Deck deck) throws DeckInvalidException, UserUnauthorizedException {
        return deckService.create(deck.setUser(getConnectedUser()), LocaleContextHolder.getLocale().getLanguage());
    }


    @Operation(summary = "Make a deck as favorite for the User Authenticated")
    @PostMapping("{id}/favorite")
    public Deck favorite(@Parameter(description = "ID of the deck")
                         @PathVariable UUID id) throws DeckNotFoundException, DeckAlreadyFavoritedException, DeckNotFavoritedException {
        return deckService.favorite(id, getConnectedUser(), LocaleContextHolder.getLocale().getLanguage());
    }

    @Operation(summary = "Unfavorite a deck for the User Authenticated")
    @PostMapping("{id}/unfavorite")
    public Deck unfavorite(@Parameter(description = "ID of the deck")
                           @PathVariable UUID id) throws DeckNotFoundException, DeckAlreadyFavoritedException, DeckNotFavoritedException {
        return deckService.unfavorite(id, getConnectedUser(), LocaleContextHolder.getLocale().getLanguage());
    }

    @Operation(summary = "Delete the deck with the id in the path. You need to be the owner of the deck")
    @DeleteMapping("{id}")
    public void delete(
            @Parameter(description = "ID of the deck")
            @PathVariable UUID id) throws DeckOwnershipException, DeckNotFoundException {
        deckService.delete(id, getConnectedUser());
    }

    private User getConnectedUser() {
        String connectedMail = SecurityContextHolder.getContext().getAuthentication().getName();
        if (connectedMail.equals("anonymousUser")) {
            return null;
        }
        return new User().setMail(connectedMail);
    }

}
