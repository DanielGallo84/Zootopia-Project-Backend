package org.vero_slaves.zootopia.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vero_slaves.zootopia.exceptions.AnimalNotFoundException;
import org.vero_slaves.zootopia.interfaces.IGenericLimitedService;
import org.vero_slaves.zootopia.models.Family;
import org.vero_slaves.zootopia.repositories.FamilyRepository;

@Service
public class FamilyService implements IGenericLimitedService<Family> {
    
   FamilyRepository repository;

    public FamilyService(FamilyRepository repository) {
        this.repository = repository;
    }

    public List<Family> getAll() {
        List<Family> types = repository.findAll();
        return types;
    }

    public Family getById(Long id) throws Exception {
        Family animal = repository.findById(id).orElseThrow(() -> new AnimalNotFoundException("Family not found"));

        return animal;
    }

    public Family save(Family type) {

        Family newFamily = new Family();

        repository.save(newFamily);
        return newFamily;
    }
}