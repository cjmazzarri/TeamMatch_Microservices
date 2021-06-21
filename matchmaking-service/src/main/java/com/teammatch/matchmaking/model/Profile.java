package com.teammatch.matchmaking.model;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class Profile {
    private Long profileId;
    private String fullName;
    private String username;
    private String description;
    private String gender;
    private String email;
    private String phoneNumber;
    private String birthDate;
}
