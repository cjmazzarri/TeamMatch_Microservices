package com.teammatch.profile.entity;

import com.teammatch.profile.model.Player;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "profiles")
@Data

public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 20)
    @Column(name = "full_name")
    private String fullName;

    @NotBlank
    @NotNull
    @Size(max = 20)
    private String username;

    @NotBlank
    @NotNull
    @Size(max = 50)
    private String description;

    @NotBlank
    @NotNull
    @Size(max = 20)
    private String gender;

    @NotBlank
    @NotNull
    @Size(max = 30)
    private String email;

    @NotBlank
    @NotNull
    @Size(max = 30)
    private String phoneNumber;

    @NotBlank
    @NotNull
    @Size(max = 30)
    private String birthDate;

    @Transient
    private Player player;


    public Profile setId(Long id) {
        this.id = id;
        return this;
    }
}