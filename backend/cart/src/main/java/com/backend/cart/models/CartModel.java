package com.backend.cart.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "Cart")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID cartId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private UUID itemId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private String platform;
}
