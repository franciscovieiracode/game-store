package com.store.catalog.models;

import com.store.catalog.enums.PlatformEnums;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "PLATFORM")
public class PlatformModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int platformId;

    @Column(nullable = false)
    private PlatformEnums platformEnums;

    @OneToMany(mappedBy = "platformModel")
    private List<GamePlatformModel> gamePlatformModels;

}
