package com.opcgdb_api.repository;

import com.opcgdb_api.entity.ColorDescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ColorDescriptionDao extends JpaRepository<ColorDescriptionEntity, String>, JpaSpecificationExecutor<ColorDescriptionEntity> {

}
