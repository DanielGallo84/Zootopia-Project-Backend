package org.vero_slaves.zootopia.services;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.vero_slaves.zootopia.exceptions.AnimalNotFoundException;
import org.vero_slaves.zootopia.interfaces.IGenericLimitedService;
import org.vero_slaves.zootopia.models.User;
import org.vero_slaves.zootopia.repositories.UserRepository;

@Service
public class UserService implements IGenericLimitedService<User> {
    
   UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        List<User> types = repository.findAll();
        return types;
    }

    public User getById(Long id) throws Exception {
        User user = repository.findById(id).orElseThrow(() -> new AnimalNotFoundException("User not found"));

        return user;
    }

    public User save(@NonNull User type) {

        User newUser = new User();

        repository.save(newUser);
        return newUser;
    }
}