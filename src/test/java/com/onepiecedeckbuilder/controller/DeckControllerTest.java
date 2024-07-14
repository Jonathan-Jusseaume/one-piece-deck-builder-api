package com.onepiecedeckbuilder.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.onepiecedeckbuilder.dto.Card;
import com.onepiecedeckbuilder.dto.Deck;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class DeckControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("provideParametersAndExpectedResults")
    @DisplayName("List should return filtered decks based on various parameters")
    void list_shouldReturnFilteredDecksMatchingParameters(String queryParams, List<Deck> expectedDecks) throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/decks?" + queryParams)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TypeReference<RestResponsePage<Deck>> deckPageTypeReference = new TypeReference<>() {
        };
        RestResponsePage<Deck> actualPage = objectMapper.readValue(jsonResponse, deckPageTypeReference);
        List<Deck> actualDecks = actualPage.getContent();

        assertThat(actualDecks
                .stream()
                .map(Deck::getId)
                .toList())
                .containsExactlyInAnyOrderElementsOf(expectedDecks
                        .stream()
                        .map(Deck::getId)
                        .toList());
    }

    @Test
    @WithMockUser(username = "test-user@test.com")
    @DisplayName("List should return filtered decks of user when onlyUserDeck is true")
    void list_shouldReturnDecksOfUser_whenOnlyUserDeckIsTrue() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/decks?onlyUserDeck=true")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TypeReference<RestResponsePage<Deck>> deckPageTypeReference = new TypeReference<>() {
        };
        RestResponsePage<Deck> actualPage = objectMapper.readValue(jsonResponse, deckPageTypeReference);
        List<Deck> actualDecks = actualPage.getContent();

        assertThat(actualDecks
                .stream()
                .map(Deck::getId)
                .toList())
                .containsExactlyInAnyOrderElementsOf(List.of(UUID.fromString("97e852fe-3810-4f60-a143-da10e7c8a760")));
    }

    @Test
    @WithMockUser(username = "test-user@test.com")
    @DisplayName("List should return filtered decks of user's favorite when onlyFavorite is true")
    void list_shouldReturnDecksOfUserSFavorite_whenOnlyFavoriteIsTrue() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/decks?onlyFavorite=true")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TypeReference<RestResponsePage<Deck>> deckPageTypeReference = new TypeReference<>() {
        };
        RestResponsePage<Deck> actualPage = objectMapper.readValue(jsonResponse, deckPageTypeReference);
        List<Deck> actualDecks = actualPage.getContent();

        assertThat(actualDecks
                .stream()
                .map(Deck::getId)
                .toList())
                .containsExactlyInAnyOrderElementsOf(List.of(UUID.fromString("97e852fe-3810-4f60-a143-da10e7c8a680")));

        assertThat(actualDecks.stream().map(Deck::getFavorite)).allMatch(expected -> expected.equals(Boolean.TRUE));
    }

    @Test
    @DisplayName("List should return 401 unauthorized when onlyFavorite is true and user is not authenticated")
    void list_shouldReturn401Unauthorized_whenOnlyFavoriteTrueAndUserNotAuthenticated() throws Exception {
        this.mockMvc.perform(get("/decks?onlyFavorite=true")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("List should return 401 unauthorized when onlyUserDeck is true and user is not authenticated")
    void list_shouldReturn401Unauthorized_whenOnlyUserDeckTrueAndUserNotAuthenticated() throws Exception {
        this.mockMvc.perform(get("/decks?onlyUserDeck=true")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @DisplayName("Read should return 404 not found when the deck with the given ID does not exist")
    void read_shouldReturn404NotFound_whenDeckWithIDDoesNotExist() throws Exception {
        this.mockMvc.perform(get("/decks/97e852fe-3810-4f60-a143-da10e7c8a681")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Read should return deck matching the given ID")
    void read_shouldReturnDeckWithTheGivenID_whenIDExist() throws Exception {
        String searchedDeckID = "97e852fe-3810-4f60-a143-da10e7c8a680";
        MvcResult mvcResult = this.mockMvc.perform(get("/decks/" + searchedDeckID)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Deck actualDeck = objectMapper.readValue(jsonResponse, Deck.class);

        assertThat(actualDeck.getId()).isEqualTo(UUID.fromString(searchedDeckID));
        assertThat(actualDeck.getCards()).hasSize(50);
    }

    @Test
    @WithMockUser(username = "test-user")
    @DisplayName("Create should return precondition failed when the number of cards in the deck is invalid")
    void create_shouldReturnPreconditionFailed_whenNumberOfCardsIsInvalid() throws Exception {
        Deck invalidDeck = new Deck()
                .setName("Test Deck")
                .setLeader(new Card().setId("ST01-001"))
                .setCards(Collections.emptyList());

        this.mockMvc.perform(post("/decks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(invalidDeck))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isPreconditionFailed());
    }

    @Test
    @WithMockUser(username = "test-user")
    @DisplayName("Create should return precondition failed when the leader is not filled")
    void create_shouldReturnPreconditionFailed_whenLeaderIsNotFilled() throws Exception {
        Deck invalidDeck = new Deck()
                .setName("Test Deck")
                .setCards(sampleCardList());

        this.mockMvc.perform(post("/decks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(invalidDeck))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isPreconditionFailed());
    }

    @Test
    @WithMockUser(username = "test-user")
    @DisplayName("Create should return precondition failed when the leader does not exist")
    void create_shouldReturnPreconditionFailed_whenLeaderDoesNotExist() throws Exception {
        Deck invalidDeck = new Deck()
                .setName("Test Deck")
                .setLeader(new Card().setId("ST-TEST"))
                .setCards(sampleCardList());

        this.mockMvc.perform(post("/decks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(invalidDeck))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isPreconditionFailed());
    }

    @Test
    @WithMockUser(username = "test-user")
    @DisplayName("Create should return precondition failed when cards are not of the color of the leader")
    void create_shouldReturnPreconditionFailed_whenCardsAreNotOfTheColorOfTheLeader() throws Exception {
        Deck invalidDeck = new Deck()
                .setName("Test Deck")
                .setLeader(new Card().setId("ST01-001"))
                .setCards(sampleCardList());

        this.mockMvc.perform(post("/decks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(invalidDeck))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isPreconditionFailed());
    }

    @Test
    @WithAnonymousUser
    @DisplayName("Create should return success when the deck is valid")
    @Rollback
    @Transactional
    void create_shouldReturnSuccess_whenDeckIsValid() throws Exception {
        Deck validDeck = createValidDeck();

        MvcResult mvcResult = this.mockMvc.perform(post("/decks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(validDeck))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Deck createdDeck = objectMapper.readValue(jsonResponse, Deck.class);
        assertThat(createdDeck.getName()).isEqualTo(validDeck.getName());
        assertThat(createdDeck.getCountFavorites()).isZero();
    }

    @Test
    @WithMockUser(username = "test-user")
    @DisplayName("Delete should return 404 not found when the deck with the given ID does not exist")
    void delete_shouldReturn404NotFound_whenDeckWithIDDoesNotExist() throws Exception {
        this.mockMvc.perform(delete("/decks/97e852fe-3810-4f60-a143-da10e7c8a681")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "test-user")
    @DisplayName("Delete should return 403 forbidden when the deck with the given ID does not belong to the user")
    void delete_shouldReturn403Forbidden_whenDeckWithIDDoesNotBelongToUser() throws Exception {
        this.mockMvc.perform(delete("/decks/97e852fe-3810-4f60-a143-da10e7c8a680")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "second-test-user@test.com")
    @DisplayName("Delete should return success when the deck with the given ID belongs to the user")
    @Rollback
    @Transactional
    void delete_shouldReturnSuccess_whenDeckWithIDBelongsToUser() throws Exception {
        this.mockMvc.perform(delete("/decks/97e852fe-3810-4f60-a143-da10e7c8a680")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        this.mockMvc.perform(get("/decks/97e852fe-3810-4f60-a143-da10e7c8a680")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "test-user@test.com")
    @DisplayName("Favorite should return conflict when the deck with the given ID is already a favorite deck of the user")
    void favorite_shouldReturnConflict_whenDeckIsAlreadyFavoriteOfUser() throws Exception {
        this.mockMvc.perform(post("/decks/97e852fe-3810-4f60-a143-da10e7c8a680/favorite")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict());
    }

    @Test
    @WithMockUser(username = "test-user@test.com")
    @DisplayName("Favorite should return success when the deck is not already a favorite deck of the user")
    @Rollback
    @Transactional
    void favorite_shouldReturnSuccess_whenDeckIsANewFavoriteDeckOfUser() throws Exception {
        String favoriteDeckID = "97e852fe-3810-4f60-a143-da10e7c8a760";

        this.mockMvc.perform(post("/decks/" + favoriteDeckID + "/favorite")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult mvcResult = this.mockMvc.perform(get("/decks/" + favoriteDeckID)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Deck actualDeck = objectMapper.readValue(jsonResponse, Deck.class);

        assertThat(actualDeck.getCountFavorites()).isEqualTo(1);
    }

    @Test
    @WithMockUser(username = "test-user@test.com")
    @DisplayName("Unfavorite should return conflict when the deck with the given ID is not a favorite deck of the user")
    void unfavorite_shouldReturnConflict_whenDeckIsNotFavoriteOfUser() throws Exception {
        this.mockMvc.perform(post("/decks/97e852fe-3810-4f60-a143-da10e7c8a760/unfavorite")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict());
    }

    @Test
    @WithMockUser(username = "test-user@test.com")
    @DisplayName("Unfavorite should return success when the deck is a favorite deck of the user")
    @Rollback
    @Transactional
    void unfavorite_shouldReturnSuccess_whenDeckIsAFavoriteDeckOfUser() throws Exception {
        String unfavoriteDeckID = "97e852fe-3810-4f60-a143-da10e7c8a680";

        this.mockMvc.perform(post("/decks/" + unfavoriteDeckID + "/unfavorite")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        MvcResult mvcResult = this.mockMvc.perform(get("/decks/" + unfavoriteDeckID)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        Deck actualDeck = objectMapper.readValue(jsonResponse, Deck.class);

        assertThat(actualDeck.getCountFavorites()).isZero();
    }

    private static Stream<Arguments> provideParametersAndExpectedResults() {
        return Stream.of(
                Arguments.of("page=0&size=10", List.of(new Deck().setId(UUID.fromString("97e852fe-3810-4f60-a143-da10e7c8a760")),
                        new Deck().setId(UUID.fromString("97e852fe-3810-4f60-a143-da10e7c8a680")))),
                Arguments.of("page=0&size=10&keyword=luffy !starter", Collections.emptyList())
        );
    }

    private static Deck createValidDeck() {
        return new Deck()
                .setLeader(new Card().setId("ST02-001"))
                .setName("KID STARTER")
                .setDescription("Example of a deck. This is the second starter")
                .setCards(sampleCardList());
    }

    private static List<Card> sampleCardList() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 4; i++) cards.add(new Card().setId("ST02-006"));
        for (int i = 0; i < 4; i++) cards.add(new Card().setId("ST02-007"));
        for (int i = 0; i < 4; i++) cards.add(new Card().setId("ST02-003"));
        for (int i = 0; i < 4; i++) cards.add(new Card().setId("ST02-002"));
        for (int i = 0; i < 4; i++) cards.add(new Card().setId("ST02-011"));
        for (int i = 0; i < 4; i++) cards.add(new Card().setId("ST02-004"));
        for (int i = 0; i < 4; i++) cards.add(new Card().setId("ST02-009"));
        for (int i = 0; i < 4; i++) cards.add(new Card().setId("ST02-013"));
        for (int i = 0; i < 4; i++) cards.add(new Card().setId("ST02-005"));
        for (int i = 0; i < 4; i++) cards.add(new Card().setId("ST02-008"));
        for (int i = 0; i < 4; i++) cards.add(new Card().setId("ST02-010"));
        for (int i = 0; i < 2; i++) cards.add(new Card().setId("ST02-012"));
        for (int i = 0; i < 2; i++) cards.add(new Card().setId("ST02-014"));
        for (int i = 0; i < 2; i++) cards.add(new Card().setId("ST02-016"));
        return cards;
    }

    public static class RestResponsePage<T> extends PageImpl<T> {
        @JsonCreator
        public RestResponsePage(@JsonProperty("content") List<T> content,
                                @JsonProperty("number") int number,
                                @JsonProperty("size") int size,
                                @JsonProperty("totalElements") long totalElements,
                                @JsonProperty("pageable") JsonNode pageable,
                                @JsonProperty("last") boolean last,
                                @JsonProperty("totalPages") int totalPages,
                                @JsonProperty("sort") JsonNode sort,
                                @JsonProperty("first") boolean first,
                                @JsonProperty("empty") boolean empty,
                                @JsonProperty("numberOfElements") int numberOfElements) {
            super(content, PageRequest.of(number, size), totalElements);
        }

    }
}
