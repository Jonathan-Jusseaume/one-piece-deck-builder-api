package com.opcgdb_api.service;

import com.opcgdb_api.dto.Type;
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
class TypeServiceTest {

    @Autowired
    private TypeService typeService;

    @ParameterizedTest
    @MethodSource("provideLanguageCodesAndExpectedTypes")
    @DisplayName("Should return all types for given language")
    void shouldReturnAllTypesForGivenLanguage(String languageCode, List<Type> expected) {
        List<Type> actual = this.typeService.list(languageCode);
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> provideLanguageCodesAndExpectedTypes() {
        return Stream.of(
                Arguments.of("en", Arrays.asList(
                        new Type().setId(1L).setLabel("Character"),
                        new Type().setId(0L).setLabel("Leader"),
                        new Type().setId(2L).setLabel("Stage"),
                        new Type().setId(3L).setLabel("Event")
                )),
                Arguments.of("fr", Arrays.asList(
                        new Type().setId(1L).setLabel("Personnage"),
                        new Type().setId(0L).setLabel("Capitaine"),
                        new Type().setId(2L).setLabel("Terrain"),
                        new Type().setId(3L).setLabel("Événement")
                ))
        );
    }
}
