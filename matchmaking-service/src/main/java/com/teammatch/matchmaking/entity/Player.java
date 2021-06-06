package com.teammatch.matchmaking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name="players")
public class Player implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 100)
    @Column(name="username", nullable=false)
    private String username;

    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column(name="password", nullable=false)
    private String password;

    @NotNull
    @Column(name="hours", nullable=false)
    private int hours;

    @NotNull
    @NotBlank
    @Column(name="last_connection", nullable=false)
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
