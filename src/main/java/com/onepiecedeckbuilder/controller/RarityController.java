package com.onepiecedeckbuilder.controller;

import com.onepiecedeckbuilder.dto.Rarity;
import com.onepiecedeckbuilder.service.RarityService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rarities")
@RequiredArgsConstructor
public class RarityController {

    private final RarityService rarityService;

    @Operation(summary = "Get the list of all the different rarities")
    @GetMapping
    public List<Rarity> list() {
        return rarityService.list();
    }

}
