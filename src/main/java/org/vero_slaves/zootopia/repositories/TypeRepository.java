package org.vero_slaves.zootopia.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vero_slaves.zootopia.models.Type;

public interface TypeRepository extends JpaRepository<Type, Long>{
    public Optional<Type> findByType(String type);
}
