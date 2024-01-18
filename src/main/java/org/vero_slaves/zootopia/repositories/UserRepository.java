package org.vero_slaves.zootopia.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vero_slaves.zootopia.models.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
    public Optional<User> findByUsername(String username);

}