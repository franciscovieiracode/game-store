package com.store.catalog.services;

import com.store.catalog.dto.PlatformDto;
import com.store.catalog.enums.PlatformEnums;
import com.store.catalog.models.PlatformModel;
import com.store.catalog.repositories.PlatformRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformService {

    @Autowired
    PlatformRepository platformRepository;

    public List<PlatformModel> getAllPlatforms(){
        return platformRepository.findAll();
    }

    public PlatformModel save(PlatformDto platformDto){

        PlatformModel platformModel = new PlatformModel();
        platformModel.setPlatformEnums(PlatformEnums.valueOf(platformDto.platform()));

        return platformRepository.save(platformModel);
    }

}
