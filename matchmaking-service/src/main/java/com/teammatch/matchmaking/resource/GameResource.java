package com.teammatch.matchmaking.resource;

import lombok.Data;

@Data
public class GameResource {
    private Long id;
    private String name;
    private int gameTeamSize;
}
