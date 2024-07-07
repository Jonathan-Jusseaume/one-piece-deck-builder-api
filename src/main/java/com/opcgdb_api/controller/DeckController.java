package com.opcgdb_api.controller;

import com.opcgdb_api.config.resolvers.LanguageResolver;
import com.opcgdb_api.config.resolvers.UserResolver;
import com.opcgdb_api.dto.Deck;
import com.opcgdb_api.dto.User;
import com.opcgdb_api.exceptions.*;
import com.opcgdb_api.service.DeckService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/decks")
@RequiredArgsConstructor
public class DeckController {

    private final UserResolver userResolver;

    private final LanguageResolver languageResolver;

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
            Boolean onlyUserDeck,
            HttpServletRequest request) throws UserUnauthorizedException {
        User connectedUser = userResolver.resolveUserFromRequest(request);
        return deckService.list(
                pageable, onlyUserDeck, colorsId, keyword, connectedUser, onlyFavorite,
                languageResolver.resolveLocale(request).getLanguage()
        );
    }

    @Operation(summary = "Read the deck with the ID in the path")
    @GetMapping("{id}")
    public Deck read(
            @Parameter(description = "ID of the deck")
            @PathVariable UUID id,
            HttpServletRequest request) throws DeckNotFoundException {
        return deckService.read(id, languageResolver.resolveLocale(request).getLanguage(),
                this.getMailIfUserConnected(request));
    }


    @Operation(summary = "Create a deck for the User Authenticated")
    @PostMapping
    public Deck create(@RequestBody Deck deck, HttpServletRequest request) throws DeckInvalidException, UserUnauthorizedException {
        User connectedUser = getConnectedUser(request);
        deck.setUser(connectedUser);
        return deckService.create(deck, languageResolver.resolveLocale(request).getLanguage());
    }


    @Operation(summary = "Make a deck as favorite for the User Authenticated")
    @PostMapping("{id}/favorite")
    public Deck favorite(@Parameter(description = "ID of the deck")
                         @PathVariable UUID id, HttpServletRequest request) throws DeckNotFoundException, UserUnauthorizedException, DeckAlreadyFavoritedException, DeckNotFavoritedException {
        User connectedUser = getConnectedUser(request);
        return deckService.favorite(id, connectedUser, languageResolver.resolveLocale(request).getLanguage());
    }

    @Operation(summary = "Unfavorite a deck for the User Authenticated")
    @PostMapping("{id}/unfavorite")
    public Deck unfavorite(@Parameter(description = "ID of the deck")
                           @PathVariable UUID id, HttpServletRequest request) throws DeckNotFoundException, UserUnauthorizedException, DeckAlreadyFavoritedException, DeckNotFavoritedException {
        User connectedUser = getConnectedUser(request);
        return deckService.unfavorite(id, connectedUser, languageResolver.resolveLocale(request).getLanguage());
    }

    @Operation(summary = "Delete the deck with the id in the path. You need to be the owner of the deck")
    @DeleteMapping("{id}")
    public void delete(
            @Parameter(description = "ID of the deck")
            @PathVariable UUID id,
            HttpServletRequest request) throws DeckOwnershipException, DeckNotFoundException, UserUnauthorizedException {
        User connectedUser = getConnectedUser(request);
        deckService.delete(id, connectedUser.getMail());
    }

    private User getConnectedUser(HttpServletRequest request) throws UserUnauthorizedException {
        User connectedUser = userResolver.resolveUserFromRequest(request);
        if (connectedUser == null || connectedUser.getMail() == null
                || connectedUser.getMail().isEmpty()) {
            throw new UserUnauthorizedException();
        }
        return connectedUser;
    }

    private String getMailIfUserConnected(HttpServletRequest request) {
        User connectedUser = userResolver.resolveUserFromRequest(request);
        String mail = null;
        if (connectedUser != null && connectedUser.getMail() != null) {
            mail = connectedUser.getMail();
        }
        return mail;
    }

}
