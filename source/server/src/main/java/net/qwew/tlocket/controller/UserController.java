package net.qwew.tlocket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.qwew.tlocket.entity.User;
import net.qwew.tlocket.exception.UsernameAlreadyExistsException;
import net.qwew.tlocket.exception.UsernameCollisionException;
import net.qwew.tlocket.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    UserService userService;
    
    @GetMapping
    public ResponseEntity<String> getUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok().body(users.toString());
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody User user) {
        try {
            return ResponseEntity.ok().body(userService.addUser(user).toString());
        }
        
        catch(UsernameAlreadyExistsException usernameExists) {
            return ResponseEntity.badRequest().body(usernameExists.getMessage());
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body("Something unexpected is happening:\n"+e.toString());
        }
    }

    @PatchMapping
    public ResponseEntity<String> usernameChange(@RequestBody User user) {
        try {
            return ResponseEntity.ok().body(userService.changeUsername(user).toString());
        }

        catch(UsernameCollisionException userCollision) {
            return ResponseEntity.badRequest().body(userCollision.getMessage());
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().body("Something unexpected is happening:\n"+e.toString());
        }
    }
}
