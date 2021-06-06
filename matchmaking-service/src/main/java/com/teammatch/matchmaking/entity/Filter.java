package com.teammatch.matchmaking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "filters")
@Data
public class Filter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String game;

    @NotBlank
    @NotNull
    private int age;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String region;

    @NotBlank
    @NotNull
    @Size(max = 100)
    @Column(name="game_style", nullable=false)
    private String gameStyle;

    @NotBlank
    @NotNull
    @Column(name="account_level", nullable=false)
    private int accountLevel;

    @NotBlank
    @NotNull
    private float rating;

    @OneToOne(mappedBy = "filter")
    @JsonIgnore
    private Player player;

    @OneToOne(mappedBy = "filter")
    @JsonIgnore
    private Team team;
}
