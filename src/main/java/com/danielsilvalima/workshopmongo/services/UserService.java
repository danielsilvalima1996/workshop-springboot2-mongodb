package com.danielsilvalima.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import com.danielsilvalima.workshopmongo.domain.User;
import com.danielsilvalima.workshopmongo.dto.UserDTO;
import com.danielsilvalima.workshopmongo.repository.UserRepository;
import com.danielsilvalima.workshopmongo.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj) {
        return repository.save(obj);
    }

    public void delete(String id) {
        this.findById(id);
        this.repository.deleteById(id);
    }

    public User update(User obj) {
        User newObj = this.repository.findById(obj.getId()).get();
        updateData(newObj, obj);
        return this.repository.save(obj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setEmail(obj.getEmail());
        newObj.setName(obj.getName());
    }

    public User fromDTO(UserDTO obj) {
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }

}
