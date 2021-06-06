package com.teammatch.matchmaking.resource;

import lombok.Data;

@Data
public class TeamResource {
    private Long id;
    private String teamName;
    private int teamSize;
    float average;
    float hoursPlayed;
}
