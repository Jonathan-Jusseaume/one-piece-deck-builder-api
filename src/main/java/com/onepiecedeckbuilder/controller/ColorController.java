package com.onepiecedeckbuilder.controller;

import com.onepiecedeckbuilder.dto.Color;
import com.onepiecedeckbuilder.service.ColorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/colors")
@RequiredArgsConstructor
public class ColorController {

    private final ColorService colorService;

    @Operation(summary = "Get the list of all the different colors")
    @GetMapping
    public List<Color> list() {
        return colorService.list(LocaleContextHolder.getLocale().getLanguage());
    }

}
