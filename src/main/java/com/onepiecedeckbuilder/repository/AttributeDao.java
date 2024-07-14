package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.AttributeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttributeDao extends JpaRepository<AttributeEntity, Long>, JpaSpecificationExecutor<AttributeEntity> {

}
