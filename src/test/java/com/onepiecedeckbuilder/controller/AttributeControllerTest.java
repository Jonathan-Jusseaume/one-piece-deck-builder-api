package com.onepiecedeckbuilder.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.onepiecedeckbuilder.dto.Attribute;
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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class AttributeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should return all attributes")
    void shouldReturnAllAttributesForGivenLanguage() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(get("/attributes")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Attribute>> attributeListTypeReference = new TypeReference<>() {
        };
        List<Attribute> actual = objectMapper.readValue(jsonResponse, attributeListTypeReference);

        assertThat(actual).containsExactlyInAnyOrderElementsOf(List.of(Attribute.values()));
    }

}
