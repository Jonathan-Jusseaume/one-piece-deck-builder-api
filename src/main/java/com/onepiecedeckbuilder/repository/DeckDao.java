package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.DeckEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface DeckDao extends JpaRepository<DeckEntity, UUID>, JpaSpecificationExecutor<DeckEntity> {

}
