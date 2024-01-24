package org.vero_slaves.zootopia.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vero_slaves.zootopia.models.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long>{
    public Optional<Animal> findByName(String name);
}
