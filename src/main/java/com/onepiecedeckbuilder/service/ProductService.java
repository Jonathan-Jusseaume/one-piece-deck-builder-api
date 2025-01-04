package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Product;
import com.onepiecedeckbuilder.mapper.ProductMapper;
import com.onepiecedeckbuilder.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public List<Product> list(String languageCode) {
        return productRepository.findAll()
                .stream()
                .map(productEntity -> productMapper.toDto(productEntity, languageCode))
                .sorted(Comparator.comparing(Product::getLabel))
                .toList();
    }

}

