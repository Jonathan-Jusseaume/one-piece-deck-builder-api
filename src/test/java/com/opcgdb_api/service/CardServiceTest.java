package com.opcgdb_api.service;

import com.opcgdb_api.dto.Card;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CardServiceTest {

    @Autowired
    private CardService cardService;

    @ParameterizedTest
    @MethodSource("provideParametersAndExpectedResults")
    @DisplayName("Should return filtered cards based on various parameters")
    void shouldReturnFilteredCardsBasedOnVariousParameters(Pageable pageable, Set<Long> typesId, Set<Long> colorsId, Set<Long> tagsId, Set<Long> raritiesId, Set<String> productsId, Set<Integer> costs, Set<Integer> powers, String keyword, String languageCode, List<Card> expectedCards) {

        Page<Card> actualPage = cardService.list(pageable, typesId, colorsId, tagsId, raritiesId, productsId, costs, powers, keyword, languageCode);
        List<Card> actualCards = actualPage.getContent();

        assertThat(actualCards.stream().map(Card::getId).collect(Collectors.toList())).containsExactlyInAnyOrderElementsOf(expectedCards.stream().map(Card::getId).collect(Collectors.toList()));
    }

    private static Stream<Arguments> provideParametersAndExpectedResults() {
        return Stream.of(powersParameters(),
                typeLeaderAnColorRedParameters(),
                tagSupernovasAndStrawHatStarterParameter(),
                raritySRParameter());
    }

    private static Arguments powersParameters() {
        return Arguments.of(Pageable.ofSize(10), null, null, null, null, null, null, Set.of(6000), null, "en", List.of(new Card().setId("ST01-010"), new Card().setId("ST01-012"), new Card().setId("ST02-006"), new Card().setId("ST02-009"), new Card().setId("ST02-010")));
    }

    private static Arguments typeLeaderAnColorRedParameters() {
        return Arguments.of(Pageable.ofSize(10), Set.of(0L), Set.of(0L), null, null, null, null, null, null, "en", List.of(new Card().setId("ST01-001")));
    }

    private static Arguments tagSupernovasAndStrawHatStarterParameter() {
        return Arguments.of(Pageable.ofSize(10), null, null, Set.of(1L), null, Set.of("ST-01"), null, null, null, "en", List.of(new Card().setId("ST01-001"), new Card().setId("ST01-012"), new Card().setId("ST01-013")));
    }

    private static Arguments raritySRParameter() {
        return Arguments.of(Pageable.ofSize(10), null, null, null, Set.of(3L), null, null, null, null, "en", List.of(new Card().setId("ST01-012"), new Card().setId("ST01-013"), new Card().setId("ST02-009"), new Card().setId("ST02-013")));
    }
}
