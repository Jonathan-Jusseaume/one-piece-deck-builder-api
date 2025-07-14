package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Product;
import com.onepiecedeckbuilder.mapper.ProductMapper;
import com.onepiecedeckbuilder.mapper.context.CustomMapperContext;
import com.onepiecedeckbuilder.repository.ProductRepository;
import jakarta.transaction.Transactional;
import java.util.Comparator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public List<Product> list(String languageCode) {
        return productRepository
            .findAll()
            .stream()
            .map(productEntity ->
                productMapper.toDto(
                    productEntity,
                    CustomMapperContext.builder()
                        .languageCode(languageCode)
                        .build()
                )
            )
            .sorted(Comparator.comparing(Product::getLabel))
            .toList();
    }
}
