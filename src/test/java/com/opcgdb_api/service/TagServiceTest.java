package com.opcgdb_api.service;

import com.opcgdb_api.dto.Tag;
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
class TagServiceTest {

    @Autowired
    private TagService tagService;

    @ParameterizedTest
    @MethodSource("provideLanguageCodesAndExpectedTags")
    @DisplayName("Should return all tags for given language in the specified order")
    void shouldReturnAllTagsInTheSpecifiedOrder(String languageCode, List<Tag> expected) {
        List<Tag> actual = this.tagService.list(languageCode);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideLanguageCodesAndExpectedTags() {
        return Stream.of(
                Arguments.of("en", Arrays.asList(
                        new Tag().setId(3L).setLabel("Alabasta"),
                        new Tag().setId(2L).setLabel("Animal"),
                        new Tag().setId(9L).setLabel("Bonney Pirates"),
                        new Tag().setId(14L).setLabel("Drake Pirates"),
                        new Tag().setId(7L).setLabel("Fallen Monk Pirates"),
                        new Tag().setId(6L).setLabel("Firetank Pirates"),
                        new Tag().setId(4L).setLabel("Fish-Man"),
                        new Tag().setId(12L).setLabel("Hawkins Pirates"),
                        new Tag().setId(11L).setLabel("Heart Pirates"),
                        new Tag().setId(5L).setLabel("Kid Pirates"),
                        new Tag().setId(13L).setLabel("Minks"),
                        new Tag().setId(8L).setLabel("Navy"),
                        new Tag().setId(10L).setLabel("On-Air Pirates"),
                        new Tag().setId(0L).setLabel("Straw Hat Crew"),
                        new Tag().setId(1L).setLabel("Supernovas")
                )),
                Arguments.of("fr", Arrays.asList(
                        new Tag().setId(3L).setLabel("Alabasta"),
                        new Tag().setId(2L).setLabel("Animal"),
                        new Tag().setId(0L).setLabel("Equipage du chapeau de paille"),
                        new Tag().setId(4L).setLabel("Homme-poisson"),
                        new Tag().setId(7L).setLabel("L'Équipage des Moines Dépravés"),
                        new Tag().setId(9L).setLabel("L'équipage de Bonney"),
                        new Tag().setId(14L).setLabel("L'équipage de Drake"),
                        new Tag().setId(12L).setLabel("L'équipage de Hawkins"),
                        new Tag().setId(5L).setLabel("L'équipage de Kid"),
                        new Tag().setId(6L).setLabel("L'équipage du Firetank"),
                        new Tag().setId(11L).setLabel("L'équipage du Heart"),
                        new Tag().setId(10L).setLabel("L'équipage du On-Air"),
                        new Tag().setId(8L).setLabel("Marine"),
                        new Tag().setId(13L).setLabel("Minks"),
                        new Tag().setId(1L).setLabel("Supernovas")
                ))
        );
    }

}
