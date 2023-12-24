package net.qwew.tlocket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "msg")
public class Msg {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String content;

    @ManyToOne
    @JoinColumn(name = "sender_uname")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_uname")
    private User receiver;
}
