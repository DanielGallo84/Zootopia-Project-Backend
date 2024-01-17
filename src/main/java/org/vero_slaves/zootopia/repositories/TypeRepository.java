package org.vero_slaves.zootopia.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vero_slaves.zootopia.models.Type;

public interface TypeRepository extends JpaRepository<Type, Long>{
    
}
