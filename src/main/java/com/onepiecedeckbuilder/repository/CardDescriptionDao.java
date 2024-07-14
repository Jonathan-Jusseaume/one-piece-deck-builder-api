package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.CardDescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CardDescriptionDao extends JpaRepository<CardDescriptionEntity, String>, JpaSpecificationExecutor<CardDescriptionEntity> {

}
