package net.qwew.tlocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.qwew.tlocket.entity.Msg;
import net.qwew.tlocket.entity.User;
import net.qwew.tlocket.repository.MsgRepository;

@Service
public class MsgService {
    
    @Autowired
    MsgRepository msgRepository;

    public void post(Msg msg) {
        msgRepository.save(msg);
    }

    public Msg fetchRecentByReceiver(User receiver) {
        List<Msg> userMsgs = msgRepository.findByReceiver(receiver);
        return userMsgs.get(userMsgs.size()-1);
    }
}
