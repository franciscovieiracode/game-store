package com.store.catalog.repositories;

import com.store.catalog.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRepository extends JpaRepository<GameModel, UUID> {

    boolean existsByName(String name);

    GameModel findByName(String name);

}
