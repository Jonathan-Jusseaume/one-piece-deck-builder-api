package com.onepiecedeckbuilder.controller;

import com.onepiecedeckbuilder.dto.Attribute;
import com.onepiecedeckbuilder.service.AttributeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attributes")
@RequiredArgsConstructor
@Tag(name = "attributes", description = "Operations related to card attributes")
public class AttributeController {

    private final AttributeService attributeService;

    @Operation(summary = "Get the list of all the different attributes")
    @GetMapping
    public List<Attribute> list() {
        return attributeService.list();
    }

}
