package com.store.catalog.repositories;

import com.store.catalog.enums.PlatformEnums;
import com.store.catalog.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GameRepository extends JpaRepository<GameModel, UUID> {

    boolean existsByName(String name);

    GameModel findByName(String name);

    @Query("SELECT g FROM GameModel g JOIN g.gamePlatformModels gp WHERE gp.platformModel.platformEnums = :platformEnums")
    List<GameModel> findByPlatformEnums(PlatformEnums platformEnums);

    @Query(value = "SELECT * FROM GAMES_DB LIMIT 4", nativeQuery = true)
    List<GameModel> findMostSold();
}
