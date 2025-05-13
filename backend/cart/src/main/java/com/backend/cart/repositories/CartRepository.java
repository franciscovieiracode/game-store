package com.backend.cart.repositories;

import com.backend.cart.models.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CartRepository extends JpaRepository<CartModel, UUID> {

    Optional<CartModel> findByUserIdAndItemIdAndPlatform(String userId, UUID itemId, String platform);

    Optional<List<CartModel>> findByUserId(String userId);

}
