package com.opcgdb_api.service;

import com.opcgdb_api.dto.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @ParameterizedTest
    @MethodSource("provideLanguageCodesAndExpectedProducts")
    @DisplayName("Should return all products for given language")
    void shouldReturnAllProductsForGivenLanguage(String languageCode, List<Product> expected) {
        List<Product> actual = this.productService.list(languageCode);
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
