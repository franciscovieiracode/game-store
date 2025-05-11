package com.store.catalog.services;

import com.store.catalog.dto.GameModelDto;
import com.store.catalog.dto.GamePlatformModelDto;
import com.store.catalog.enums.PlatformEnums;
import com.store.catalog.models.GameModel;
import com.store.catalog.models.GamePlatformModel;
import com.store.catalog.models.PlatformModel;
import com.store.catalog.repositories.GamePlatformRepository;
import com.store.catalog.repositories.GameRepository;
import com.store.catalog.repositories.PlatformRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlatformRepository platformRepository;

    @Autowired
    GamePlatformRepository gamePlatformRepository;

    public List<GameModel> getAllGames(){
        return gameRepository.findAll();
    }

    public List<GameModel> getMostSold(){
        return gameRepository.findMostSold();
    }

    public Optional<GameModel> findById(UUID gameId){
        return gameRepository.findById(gameId);
    }

    @Transactional
    public GameModel save(GameModelDto gameModelDto){

        if(gameRepository.existsByName(gameModelDto.name())){
            throw new IllegalArgumentException("Game already exists");
        }

        GameModel gameModel = new GameModel();
        BeanUtils.copyProperties(gameModelDto, gameModel);

        gameModel = gameRepository.save(gameModel);

        for (GamePlatformModelDto gamePlatformModelDto : gameModelDto.platforms()) {
            // Convert String to Enum
            PlatformEnums platformEnum = PlatformEnums.valueOf(gamePlatformModelDto.platform());

            // Fetch PlatformModel by enum
            PlatformModel platformModel = platformRepository.findByPlatformEnums(platformEnum);

            if (platformModel == null) {
                throw new IllegalArgumentException("Platform not found: " + platformEnum);
            }

            GamePlatformModel gamePlatformModel = new GamePlatformModel();
            gamePlatformModel.setGameModel(gameModel);
            gamePlatformModel.setPlatformModel(platformModel);
            gamePlatformModel.setPrice(gamePlatformModelDto.price());
            gamePlatformModel.setDiscount(gamePlatformModelDto.discount());
            gamePlatformModel.setStock(gamePlatformModelDto.stock());

            gamePlatformRepository.save(gamePlatformModel);
        }

        return gameModel;
    }
    public List<GameModel> getByCategory(String category){

        PlatformEnums platformEnum = PlatformEnums.valueOf(category);

        return gameRepository.findByPlatformEnums(platformEnum);
    }

}
