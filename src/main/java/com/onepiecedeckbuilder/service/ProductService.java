package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Product;
import com.onepiecedeckbuilder.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> list(String languageCode) {
        return productRepository.findAll()
                .stream()
                .map(productEntity -> new Product(productEntity, languageCode))
                .sorted()
                .toList();
    }

}

