package com.backend.cart.services;

import com.backend.cart.dto.GameDetailsModel;
import com.backend.cart.dto.ItemDto;
import com.backend.cart.dto.ItemRemoveDto;
import com.backend.cart.models.CartModel;
import com.backend.cart.repositories.CartRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public List<CartModel> getAll(){
        return cartRepository.findAll();
    }

    public List<GameDetailsModel> getAllById(Authentication authentication){

        List<CartModel> cartModels = cartRepository.findByUserId(authentication.getPrincipal().toString()).get();

        if (cartModels.isEmpty()){
            return null;
        }
        else {
            List<GameDetailsModel> gameDetailsModels = new ArrayList<>();
            String url = "http://localhost:8084/api/v1/catalog/findById/";
            RestTemplate restTemplate = new RestTemplate();

            for (CartModel cartModel: cartModels){

                GameDetailsModel gameDetailsModel = restTemplate.getForObject(url+ cartModel.getItemId(),GameDetailsModel.class);
                gameDetailsModel.setQuantity(cartModel.getQuantity());
                gameDetailsModel.setPlatform(cartModel.getPlatform());
                gameDetailsModels.add(gameDetailsModel);

            }
            return gameDetailsModels;
        }
    }

    public CartModel save(ItemDto itemDto, Authentication authentication){

        Optional<CartModel> cartModel = cartRepository.findByUserIdAndItemIdAndPlatform(authentication.getPrincipal().toString(), UUID.fromString(itemDto.itemId()), itemDto.platform());

        if(cartModel.isEmpty()){

            CartModel cartModelAdd = new CartModel();

            BeanUtils.copyProperties(itemDto, cartModelAdd);

            cartModelAdd.setItemId(UUID.fromString(itemDto.itemId()));
            cartModelAdd.setUserId(authentication.getPrincipal().toString());
            return cartRepository.save(cartModelAdd);
        }
        else {
            CartModel cartModelExist = cartModel.get();
            cartModelExist.setQuantity(cartModelExist.getQuantity() + itemDto.quantity());
            return cartRepository.save(cartModelExist);
        }

    }

    public CartModel removeItem(ItemRemoveDto itemRemoveDto, Authentication authentication)  {

        Optional<CartModel> cartModel = cartRepository.findByUserIdAndItemIdAndPlatform(authentication.getPrincipal().toString(), UUID.fromString(itemRemoveDto.itemId()), itemRemoveDto.platform());

        if (cartModel.isPresent()){
            cartRepository.delete(cartModel.get());
        }
        else {
            System.out.println("Error");
        }
        return cartModel.get();
    }
}
