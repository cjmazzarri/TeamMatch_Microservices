package com.teammatch.communication.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teammatch.communication.entities.Chat;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Player {

    private String username;
    private String password;
    private int hours;
    private String last_connection;

    //Relationship with Chat
    /*@ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "players_chats",
            joinColumns = {@JoinColumn(name = "player_id")},
            inverseJoinColumns = {@JoinColumn(name = "chat_id")})
    @JsonIgnore
    List<Chat> chats;*/

}
