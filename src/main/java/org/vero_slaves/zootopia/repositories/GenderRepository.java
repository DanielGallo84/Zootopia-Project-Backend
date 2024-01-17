package org.vero_slaves.zootopia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vero_slaves.zootopia.models.Gender;

public interface GenderRepository extends JpaRepository<Gender, Long>{
    
}
