package com.store.catalog.services;

import com.store.catalog.GameException;
import com.store.catalog.dto.GamePlatformModelDto;
import com.store.catalog.models.GameModel;
import com.store.catalog.models.GamePlatformModel;
import com.store.catalog.repositories.GamePlatformRepository;
import com.store.catalog.repositories.GameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamePlatformService {

    @Autowired
    GamePlatformRepository gamePlatformRepository;

    @Autowired
    GameRepository gameRepository;

    public GamePlatformModel save(GamePlatformModelDto gamePlatformModelDto){

        GameModel gameModel = gameRepository.findByName(gamePlatformModelDto.name());

        if (gameModel == null){
            throw new GameException("Game Not Found");
        }

        GamePlatformModel gamePlatformModel = new GamePlatformModel();
        BeanUtils.copyProperties(gamePlatformModelDto, gamePlatformModel);

        gamePlatformModel.setGameModel(gameModel);


        return gamePlatformRepository.save(gamePlatformModel);
    }

    public List<GamePlatformModel> getAllCategories(){
        return gamePlatformRepository.findAll();
    }

}
