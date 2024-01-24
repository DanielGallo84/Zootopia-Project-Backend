package org.vero_slaves.zootopia.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vero_slaves.zootopia.exceptions.GenderNotFoundException;
import org.vero_slaves.zootopia.interfaces.IGenericLimitedService;
import org.vero_slaves.zootopia.models.Gender;
import org.vero_slaves.zootopia.repositories.GenderRepository;

@Service
public class GenderService implements IGenericLimitedService<Gender> {
    
   GenderRepository repository;

    public GenderService(GenderRepository repository) {
        this.repository = repository;
    }

    public List<Gender> getAll() {
        List<Gender> genders = repository.findAll();
        return genders;
    }

    public Gender getById(Long id) throws Exception {
        Gender animal = repository.findById(id).orElseThrow(() -> new GenderNotFoundException("Gender not found"));

        return animal;
    }

    public Gender save(Gender gender) {

        Gender newGender = new Gender();

        repository.save(newGender);
        return newGender;
    }
}