package net.qwew.tlocket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class User {

    @Id
    private String username;

    @Override
    public String toString() {
        return "{\n" +
                "\t\"username\": \"" + this.username + "\"\n" +
                "}";
    }

}
