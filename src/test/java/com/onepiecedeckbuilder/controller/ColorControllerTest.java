package com.onepiecedeckbuilder.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onepiecedeckbuilder.dto.Color;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class ColorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("provideLanguageCodesAndExpectedColors")
    @DisplayName("Should return all colors for given language")
    void shouldReturnAllColorsForGivenLanguage(String languageCode, List<Color> expected) throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/colors")
                        .header("Accept-Language", languageCode)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Color>> colorListTypeReference = new TypeReference<>() {
        };
        List<Color> actual = objectMapper.readValue(jsonResponse, colorListTypeReference);

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
