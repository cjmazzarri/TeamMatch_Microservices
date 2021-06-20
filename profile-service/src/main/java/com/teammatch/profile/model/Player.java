package com.teammatch.profile.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Player {
    private Long id;
    private String username;
    private int hours;
    private String last_connection;
}
