package com.opcgdb_api.service;

import com.opcgdb_api.dto.Color;
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
class ColorServiceTest {

    @Autowired
    private ColorService colorService;

    @ParameterizedTest
    @MethodSource("provideLanguageCodesAndExpectedColors")
    @DisplayName("Should return all colors for given language")
    void shouldReturnAllColorsForGivenLanguage(String languageCode, List<Color> expected) {
        List<Color> actual = this.colorService.list(languageCode);
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> provideLanguageCodesAndExpectedColors() {
        return Stream.of(
                Arguments.of("en", Arrays.asList(
                        new Color().setId(1L).setLabel("Green"),
                        new Color().setId(0L).setLabel("Red"),
                        new Color().setId(2L).setLabel("Blue"),
                        new Color().setId(3L).setLabel("Purple"),
                        new Color().setId(4L).setLabel("Black"),
                        new Color().setId(5L).setLabel("Yellow")
                )),
                Arguments.of("fr", Arrays.asList(
                        new Color().setId(1L).setLabel("Vert"),
                        new Color().setId(0L).setLabel("Rouge"),
                        new Color().setId(2L).setLabel("Bleu"),
                        new Color().setId(3L).setLabel("Violet"),
                        new Color().setId(4L).setLabel("Noir"),
                        new Color().setId(5L).setLabel("Jaune")
                ))
        );
    }
}
