package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeDao extends JpaRepository<TypeEntity, Long>, JpaSpecificationExecutor<TypeEntity> {

}
