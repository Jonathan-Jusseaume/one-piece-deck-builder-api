package com.onepiecedeckbuilder.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onepiecedeckbuilder.dto.Attribute;
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
class AttributeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("provideLanguageCodesAndExpectedAttributes")
    @DisplayName("Should return all attributes for given language")
    void shouldReturnAllAttributesForGivenLanguage(String languageCode, List<Attribute> expected) throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/attributes")
                        .header("Accept-Language", languageCode)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Attribute>> attributeListTypeReference = new TypeReference<>() {};
        List<Attribute> actual = objectMapper.readValue(jsonResponse, attributeListTypeReference);

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
