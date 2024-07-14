package com.onepiecedeckbuilder.service;

import com.onepiecedeckbuilder.dto.Product;
import com.onepiecedeckbuilder.repository.ProductDao;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {

    private final ProductDao productDao;

    public List<Product> list(String languageCode) {
        return productDao.findAll()
                .stream()
                .map(productEntity -> new Product(productEntity, languageCode))
                .toList();
    }

}

