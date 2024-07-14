package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TagDao extends JpaRepository<TagEntity, Long>, JpaSpecificationExecutor<TagEntity> {

}
