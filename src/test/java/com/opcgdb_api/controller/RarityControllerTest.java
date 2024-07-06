package com.opcgdb_api.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opcgdb_api.dto.Rarity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class RarityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return all rarities in the specified order")
    void shouldReturnAllRaritiesInTheSpecifiedOrder() throws Exception {
        List<Rarity> expected = Arrays.asList(
                new Rarity().setId(0L).setLabel("L"),
                new Rarity().setId(1L).setLabel("C"),
                new Rarity().setId(2L).setLabel("UC"),
                new Rarity().setId(5L).setLabel("R"),
                new Rarity().setId(3L).setLabel("SR"),
                new Rarity().setId(4L).setLabel("SEC"),
                new Rarity().setId(6L).setLabel("SP CARD"),
                new Rarity().setId(7L).setLabel("P")
        );

        MvcResult mvcResult = this.mockMvc.perform(get("/rarities")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Rarity>> rarityListTypeReference = new TypeReference<>() {};
        List<Rarity> actual = objectMapper.readValue(jsonResponse, rarityListTypeReference);

        assertThat(actual).isEqualTo(expected);
    }
}
