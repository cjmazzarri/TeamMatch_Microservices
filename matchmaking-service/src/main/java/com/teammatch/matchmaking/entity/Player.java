package com.teammatch.matchmaking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "players")
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 100)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 100)
    private String password;

    @NotNull
    private int hours;

    @NotNull
    @NotBlank
    private String last_connection;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "players_games",
            joinColumns = {@JoinColumn(name = "player_id")},
            inverseJoinColumns = {@JoinColumn(name = "game_id")})
    @JsonIgnore
    List<Game> games;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "filter_id", referencedColumnName = "id")
    private Filter filter;
}
