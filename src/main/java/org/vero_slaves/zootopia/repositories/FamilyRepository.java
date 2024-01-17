package org.vero_slaves.zootopia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vero_slaves.zootopia.models.Family;

public interface FamilyRepository extends JpaRepository<Family, Long>{
    
}
