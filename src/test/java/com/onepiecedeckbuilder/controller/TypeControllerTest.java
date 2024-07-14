package com.onepiecedeckbuilder.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onepiecedeckbuilder.dto.Type;
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
class TypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("provideLanguageCodesAndExpectedTypes")
    @DisplayName("Should return all types for given language")
    void shouldReturnAllTypesForGivenLanguage(String languageCode, List<Type> expected) throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/types")
                        .header("Accept-Language", languageCode)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Type>> typeListTypeReference = new TypeReference<>() {
        };
        List<Type> actual = objectMapper.readValue(jsonResponse, typeListTypeReference);

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
