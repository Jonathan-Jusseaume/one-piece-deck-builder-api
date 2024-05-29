package com.opcgdb_api.service;

import com.opcgdb_api.dto.Attribute;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AttributeServiceTest {

    @Autowired
    private AttributeService attributeService;

    @ParameterizedTest
    @MethodSource("provideLanguageCodesAndExpectedAttributes")
    @DisplayName("Should return all attributes for given language")
    void shouldReturnAllAttributesForGivenLanguage(String languageCode, List<Attribute> expected) {
        List<Attribute> actual = this.attributeService.list(languageCode);
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> provideLanguageCodesAndExpectedAttributes() {
        return Stream.of(
                Arguments.of("en", Arrays.asList(
                        new Attribute().setId(1L).setLabel("Ranged"),
                        new Attribute().setId(0L).setLabel("Strike"),
                        new Attribute().setId(2L).setLabel("Special"),
                        new Attribute().setId(3L).setLabel("Wisdom"),
                        new Attribute().setId(4L).setLabel("Slash")
                )),
                Arguments.of("fr", Arrays.asList(
                        new Attribute().setId(1L).setLabel("Distance"),
                        new Attribute().setId(0L).setLabel("Mêlée"),
                        new Attribute().setId(2L).setLabel("Spécial"),
                        new Attribute().setId(3L).setLabel("Intelligence"),
                        new Attribute().setId(4L).setLabel("Sabreur")
                ))
        );
    }
}
