package com.onepiecedeckbuilder.controller;

import com.onepiecedeckbuilder.dto.Attribute;
import com.onepiecedeckbuilder.service.AttributeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attributes")
@RequiredArgsConstructor
public class AttributeController {

    private final AttributeService attributeService;

    @Operation(summary = "Get the list of all the different attributes")
    @GetMapping
    public List<Attribute> list() {
        return attributeService.list(LocaleContextHolder.getLocale().getLanguage());
    }

}
