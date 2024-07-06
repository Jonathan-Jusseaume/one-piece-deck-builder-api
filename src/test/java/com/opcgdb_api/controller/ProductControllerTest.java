package com.opcgdb_api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.opcgdb_api.dto.Product;
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
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("provideLanguageCodesAndExpectedProducts")
    @DisplayName("Should return all products for given language")
    void shouldReturnAllProductsForGivenLanguage(String languageCode, List<Product> expected) throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/products")
                        .header("Accept-Language", languageCode)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        TypeReference<List<Product>> productListTypeReference = new TypeReference<>() {};
        List<Product> actual = objectMapper.readValue(jsonResponse, productListTypeReference);

        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> provideLanguageCodesAndExpectedProducts() {
        return Stream.of(
                Arguments.of("en", Arrays.asList(
                        new Product().setId("ST-01").setLabel("Straw Hat Crew [ST-01]").setReleaseDate(Instant.parse("2022-10-09T22:00:00.00Z")),
                        new Product().setId("ST-02").setLabel("Worst Generation [ST-02]").setReleaseDate(Instant.parse("2022-11-30T23:00:00.00Z"))
                )),
                Arguments.of("fr", Arrays.asList(
                        new Product().setId("ST-01").setLabel("Equipage du chapeau de paille [ST-01]").setReleaseDate(Instant.parse("2022-10-09T22:00:00.00Z")),
                        new Product().setId("ST-02").setLabel("Génération terrible [ST-02]").setReleaseDate(Instant.parse("2022-11-30T23:00:00.00Z"))
                ))
        );
    }
}
