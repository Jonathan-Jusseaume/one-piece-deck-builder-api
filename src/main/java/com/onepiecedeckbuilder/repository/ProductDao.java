package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductDao extends JpaRepository<ProductEntity, String>, JpaSpecificationExecutor<ProductEntity> {

}
