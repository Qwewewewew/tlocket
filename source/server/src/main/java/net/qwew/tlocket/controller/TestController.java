package net.qwew.tlocket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    @GetMapping("/test") 
    public static ResponseEntity<String> test() {
        return ResponseEntity.ok().body("seems to be working");
    }
}
