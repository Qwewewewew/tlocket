package net.qwew.tlocket.entity;

import com.fasterxml.jackson.databind.ObjectMapper;

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
        try {
            ObjectMapper objMapper = new ObjectMapper();
            return objMapper.writeValueAsString(this);
        }
        catch(Exception e) {
            return e.toString();
        }
    }
}
