package com.store.auth.repositories;

import com.store.auth.models.UserAuthModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthRepository extends JpaRepository<UserAuthModel, UUID> {
    UserAuthModel findByEmail(String email);

    boolean existsByEmail(String email);

}
