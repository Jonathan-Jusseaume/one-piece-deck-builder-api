package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.AttributeDescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttributeDescriptionDao extends JpaRepository<AttributeDescriptionEntity, String>, JpaSpecificationExecutor<AttributeDescriptionEntity> {

}
