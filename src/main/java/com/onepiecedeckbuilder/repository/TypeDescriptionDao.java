package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.TypeDescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TypeDescriptionDao extends JpaRepository<TypeDescriptionEntity, String>, JpaSpecificationExecutor<TypeDescriptionEntity> {

}
