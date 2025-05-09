package com.store.catalog.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int platformId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private PlatformEnums platformEnums;

    @JsonIgnore
    @JsonBackReference
    @OneToMany(mappedBy = "platformModel")
    private List<GamePlatformModel> gamePlatformModels;

}
