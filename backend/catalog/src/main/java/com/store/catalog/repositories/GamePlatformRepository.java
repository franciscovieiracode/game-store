package com.store.catalog.repositories;


import com.store.catalog.models.GamePlatformModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GamePlatformRepository extends JpaRepository<GamePlatformModel, UUID> {
}
