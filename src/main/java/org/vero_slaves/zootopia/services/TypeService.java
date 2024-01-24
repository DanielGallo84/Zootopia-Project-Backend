package org.vero_slaves.zootopia.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vero_slaves.zootopia.exceptions.TypeNotFoundException;
import org.vero_slaves.zootopia.interfaces.IGenericLimitedService;
import org.vero_slaves.zootopia.models.Type;
import org.vero_slaves.zootopia.repositories.TypeRepository;

@Service
public class TypeService implements IGenericLimitedService<Type> {
    
   TypeRepository repository;

    public TypeService(TypeRepository repository) {
        this.repository = repository;
    }

    public List<Type> getAll() {
        List<Type> types = repository.findAll();
        return types;
    }

    public Type getById(Long id) throws Exception {
        Type animal = repository.findById(id).orElseThrow(() -> new TypeNotFoundException("Type not found"));

        return animal;
    }


    public Type save(Type type) {

        Type newType = new Type();

        repository.save(newType);
        return newType;
    }
}
