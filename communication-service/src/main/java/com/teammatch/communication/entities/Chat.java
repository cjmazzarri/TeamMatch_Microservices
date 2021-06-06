package com.teammatch.communication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teammatch.communication.model.Player;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "chats")
@Data
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    //Relationship with Player
    /*@ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "chats")
    @JsonIgnore
    List<Player> players;*/
}
