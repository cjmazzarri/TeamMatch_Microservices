package com.teammatch.communication.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "chats")
@Data
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Chat setId(Long id) {
        this.id = id;
        return this;
    }
}
