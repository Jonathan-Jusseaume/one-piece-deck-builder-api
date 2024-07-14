package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.ProductDescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductDescriptionDao extends JpaRepository<ProductDescriptionEntity, String>, JpaSpecificationExecutor<ProductDescriptionEntity> {

}
