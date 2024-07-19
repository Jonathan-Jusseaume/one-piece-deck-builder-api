package com.onepiecedeckbuilder.controller;

import com.onepiecedeckbuilder.dto.Tag;
import com.onepiecedeckbuilder.service.TagService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @Operation(summary = "Get the list of all the different tags")
    @GetMapping
    public List<Tag> list() {
        return tagService.list(LocaleContextHolder.getLocale().getLanguage());
    }

}
