package net.qwew.tlocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import net.qwew.tlocket.entity.Msg;
import net.qwew.tlocket.entity.User;
import net.qwew.tlocket.service.MsgService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/msg")
public class MsgController {
    
    @Autowired
    MsgService msgService;

    @PostMapping
    public ResponseEntity<String> postMsg(@RequestBody Msg msg) {
        try{
            msgService.post(msg);
            return ResponseEntity.ok().body("Posted:\n" + msg);
        }

        catch(Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }
    
    @GetMapping
    public ResponseEntity<String> fetchMsg(@RequestBody User receiver) {
        Msg msg = msgService.fetchRecentByReceiver(receiver);
        return ResponseEntity.ok().body(msg.getContent());
    }
    
}
