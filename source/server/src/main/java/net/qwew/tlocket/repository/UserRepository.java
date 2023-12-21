package net.qwew.tlocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.qwew.tlocket.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
