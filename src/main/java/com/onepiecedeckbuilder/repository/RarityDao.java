package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.RarityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RarityDao extends JpaRepository<RarityEntity, Long>, JpaSpecificationExecutor<RarityEntity> {

}
