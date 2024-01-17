package org.vero_slaves.zootopia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vero_slaves.zootopia.models.Animal;

public interface FamilyRepository extends JpaRepository<Animal, Long>{
    
}
