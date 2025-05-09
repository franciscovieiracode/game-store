package com.store.catalog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "GAME_PLATFORM")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GamePlatformModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID gamePlatformId;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameModel gameModel;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "platform_id")
    private PlatformModel platformModel;

    @Column(nullable = false)
    private double price;

    private double discount;

    @Column(nullable = false)
    private int stock;
}
