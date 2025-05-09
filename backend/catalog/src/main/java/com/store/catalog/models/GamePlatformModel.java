package com.store.catalog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GAME_PLATFORM")
public class GamePlatformModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameModel gameModel;

    @ManyToOne
    @JoinColumn(name = "platform_id")
    private PlatformModel platformModel;

    @Column(nullable = false)
    private double price;

    private double discount;

    @Column(nullable = false)
    private int stock;
}
