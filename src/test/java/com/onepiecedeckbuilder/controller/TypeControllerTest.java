package com.onepiecedeckbuilder.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onepiecedeckbuilder.dto.Type;
import java.nio.charset.StandardCharsets;
import java.util.List;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class TypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return all types")
    void shouldReturnAllTypesForGivenLanguage() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(
                get("/types").accept(MediaType.APPLICATION_JSON)
            )
            .andExpect(status().isOk())
            .andReturn();

        String jsonResponse = mvcResult
            .getResponse()
            .getContentAsString(StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Type>> typeListTypeReference =
            new TypeReference<>() {};
        List<Type> actual = objectMapper.readValue(
            jsonResponse,
            typeListTypeReference
        );

        assertThat(actual).containsExactlyInAnyOrderElementsOf(
            List.of(Type.values())
        );
    }
}
