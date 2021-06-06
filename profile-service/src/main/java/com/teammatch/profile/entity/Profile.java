package com.teammatch.profile.entity;

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
    private Long id;

    @NotBlank
    @NotNull
    @Size(max = 20)
    @Column(name = "full_names")
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
    private Date birthDate;

    /*
    @OneToOne(mappedBy = "profile")
    @JsonIgnore
    private Player player;
    */

    public Profile setId(Long id) {
        this.id = id;
        return this;
    }
}