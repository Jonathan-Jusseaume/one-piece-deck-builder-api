package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.TagDescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TagDescriptionDao extends JpaRepository<TagDescriptionEntity, String>, JpaSpecificationExecutor<TagDescriptionEntity> {

}
