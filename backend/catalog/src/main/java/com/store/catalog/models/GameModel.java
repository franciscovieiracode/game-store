package com.store.catalog.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "GAMES_DB")
public class GameModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID gameId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String releaseDate;

    @Column(nullable = false)
    private String developer;

    @Column(nullable = false)
    private String publisher;

    private String gameImg;

    @JsonManagedReference
    @OneToMany(mappedBy = "gameModel")
    private List<GamePlatformModel> gamePlatformModels;


}
