package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.ColorDescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ColorDescriptionDao extends JpaRepository<ColorDescriptionEntity, String>, JpaSpecificationExecutor<ColorDescriptionEntity> {

}
