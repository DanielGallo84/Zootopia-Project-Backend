package org.vero_slaves.zootopia.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vero_slaves.zootopia.models.Gender;

public interface GenderRepository extends JpaRepository<Gender, Long>{
    public Optional<Gender> findByGender(String gender);
}
