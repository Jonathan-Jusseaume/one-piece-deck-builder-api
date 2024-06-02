package com.opcgdb_api.service;

import com.opcgdb_api.dto.Rarity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class RarityServiceTest {

    @Autowired
    private RarityService rarityService;

    @Test
    @DisplayName("Should return all rarities in the specified order")
    void shouldReturnAllRaritiesInTheSpecifiedOrder() {
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

        List<Rarity> actual = this.rarityService.list();
        assertThat(actual).isEqualTo(expected);
    }

}
