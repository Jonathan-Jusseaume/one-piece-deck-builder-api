package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
