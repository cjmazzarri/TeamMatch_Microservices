package com.teammatch.matchmaking.resource;

import lombok.Data;

@Data
public class PlayerResource {
    private Long id;
    private String username;
    private String password;
    private int hours;
    private String last_connection;
}
