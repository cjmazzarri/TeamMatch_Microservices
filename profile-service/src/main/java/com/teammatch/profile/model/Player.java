package com.teammatch.profile.model;

import lombok.Builder;
import lombok.Data;

@Data
public class Player {
    private Long id;
    private String username;
    private int hours;
    private String last_connection;
}
