package net.qwew.tlocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.qwew.tlocket.entity.Msg;
import net.qwew.tlocket.entity.User;

import java.util.List;


public interface MsgRepository extends JpaRepository<Msg, Long> {
    public List<Msg> findByReceiver(User receiver);
}
