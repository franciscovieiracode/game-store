package com.backend.cart.services;

import com.backend.cart.dto.ItemDto;
import com.backend.cart.dto.ItemRemoveDto;
import com.backend.cart.models.CartModel;
import com.backend.cart.repositories.CartRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.beans.Beans;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;

    public List<CartModel> getAll(Authentication authentication){
        return cartRepository.findAll();
    }

    public CartModel save(ItemDto itemDto, Authentication authentication){

        Optional<CartModel> cartModel = cartRepository.findByUserIdAndItemId(authentication.getPrincipal().toString(), UUID.fromString(itemDto.itemId()));

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

        Optional<CartModel> cartModel = cartRepository.findByUserIdAndItemId(authentication.getPrincipal().toString(), UUID.fromString(itemRemoveDto.itemId()));

        if (cartModel.isPresent()){
            cartRepository.delete(cartModel.get());
        }
        else {
            System.out.println("Error");
        }
        return cartModel.get();
    }
}
