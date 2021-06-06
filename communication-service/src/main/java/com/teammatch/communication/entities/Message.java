package com.teammatch.communication.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teammatch.communication.model.Player;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "messages")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    @Lob
    @NotNull
    private String message;

    @NotNull
    private String sentDate;

    private boolean isHyperLink;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chat_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Chat chat;

    @Transient
    private Player player;
}