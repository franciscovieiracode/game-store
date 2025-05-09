package com.store.catalog.repositories;

import com.store.catalog.enums.PlatformEnums;
import com.store.catalog.models.PlatformModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<PlatformModel, Integer > {

    PlatformModel findByPlatformEnums(PlatformEnums name);
}
