package com.onepiecedeckbuilder.repository;

import com.onepiecedeckbuilder.entity.ColorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ColorDao extends JpaRepository<ColorEntity, Long>, JpaSpecificationExecutor<ColorEntity> {

}
