package net.qwew.tlocket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import net.qwew.tlocket.entity.User;
import net.qwew.tlocket.exception.UsernameAlreadyExistsException;
import net.qwew.tlocket.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository repository;

    public User addUser(User user) throws UsernameAlreadyExistsException {
        if(repository.existsById(user.getUsername()))
            throw new UsernameAlreadyExistsException("Username Already Taken");
        
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
