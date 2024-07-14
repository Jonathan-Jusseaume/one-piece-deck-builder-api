package com.onepiecedeckbuilder.controller;

import com.onepiecedeckbuilder.dto.Type;
import com.onepiecedeckbuilder.service.TypeService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/types")
@RequiredArgsConstructor
public class TypeController {

    private final TypeService typeService;

    @Operation(summary = "Get the list of all the different types")
    @GetMapping
    public List<Type> list() {
        return typeService.list(LocaleContextHolder.getLocale().getLanguage());
    }

}
