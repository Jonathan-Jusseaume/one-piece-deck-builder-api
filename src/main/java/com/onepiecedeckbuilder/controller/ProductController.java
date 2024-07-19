package com.onepiecedeckbuilder.controller;

import com.onepiecedeckbuilder.dto.Product;
import com.onepiecedeckbuilder.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Get the list of all the different products")
    @GetMapping
    public List<Product> list() {
        return productService.list(LocaleContextHolder.getLocale().getLanguage());
    }

}
