package com.onepiecedeckbuilder.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.onepiecedeckbuilder.dto.Card;
import org.junit.jupiter.api.DisplayName;
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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("provideParametersAndExpectedResults")
    @DisplayName("Should return filtered cards based on various parameters")
    void shouldReturnFilteredCardsBasedOnVariousParameters(String queryParams, List<Card> expectedCards) throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(get("/cards?" + queryParams)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TypeReference<RestResponsePage<Card>> cardPageTypeReference = new TypeReference<>() {
        };
        RestResponsePage<Card> actualPage = objectMapper.readValue(jsonResponse, cardPageTypeReference);
        List<Card> actualCards = actualPage.getContent();

        assertThat(actualCards
                .stream()
                .map(Card::getId)
                .toList())
                .containsExactlyInAnyOrderElementsOf(expectedCards
                        .stream()
                        .map(Card::getId)
                        .toList());
    }

    private static Stream<Arguments> provideParametersAndExpectedResults() {
        return Stream.of(
                Arguments.of("page=0&size=10&power=6000", List.of(new Card().setId("ST01-010"), new Card().setId("ST01-012"), new Card().setId("ST02-006"), new Card().setId("ST02-009"), new Card().setId("ST02-010"))),
                Arguments.of("page=0&size=10&typeId=0&colorId=0", List.of(new Card().setId("ST01-001"))),
                Arguments.of("page=0&size=10&tagId=1&productId=ST-01", List.of(new Card().setId("ST01-001"), new Card().setId("ST01-012"), new Card().setId("ST01-013"))),
                Arguments.of("page=0&size=10&rarityId=3", List.of(new Card().setId("ST01-012"), new Card().setId("ST01-013"), new Card().setId("ST02-009"), new Card().setId("ST02-013"))),
                Arguments.of("page=0&size=10&keyword=Counter", List.of(new Card().setId("ST01-014"), new Card().setId("ST02-015"), new Card().setId("ST02-016"))),
                Arguments.of("page=0&size=10&keyword=rush !luffy", List.of(new Card().setId("ST01-004"))),
                Arguments.of("page=0&size=10&cost=7&cost=5", List.of(new Card().setId("ST01-012"), new Card().setId("ST02-009"), new Card().setId("ST02-010"), new Card().setId("ST02-013")))
        );
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
