package com.backend.cart.repositories;

import com.backend.cart.models.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<CartModel, UUID> {

    Optional<CartModel> findByUserIdAndItemId(String userId, UUID itemId);

}
