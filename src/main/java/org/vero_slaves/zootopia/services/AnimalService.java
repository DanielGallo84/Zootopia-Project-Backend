package org.vero_slaves.zootopia.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vero_slaves.zootopia.exceptions.AnimalNotFoundException;
import org.vero_slaves.zootopia.interfaces.IGenericService;
import org.vero_slaves.zootopia.messages.Message;
import org.vero_slaves.zootopia.models.Animal;
import org.vero_slaves.zootopia.repositories.AnimalRepository;

@Service
public class AnimalService implements IGenericService<Animal> {
    
    AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public List<Animal> getAll() {
        List<Animal> animals = repository.findAll();
        return animals;
    }

    public Animal getById(Long id) throws Exception {
        Animal animal = repository.findById(id).orElseThrow(() -> new AnimalNotFoundException("Animal not found"));

        return animal;
    }

    public Animal getByName(String name) throws Exception {
        Animal animal = repository.findByName(name).orElseThrow(() -> new AnimalNotFoundException("Animal not found"));

        return animal;
    }

    public Animal save(Animal animal) {

        Animal newAnimal = new Animal();

        repository.save(newAnimal);
        return newAnimal;
    }

    public Animal update(Long id, Animal animal) throws Exception {
        
        Animal updatingAnimal = repository.findById(id).orElseThrow(() -> new AnimalNotFoundException("Animal not found"));
        
        updatingAnimal.setName(animal.getName());
        updatingAnimal.setPhoto(animal.getPhoto());
        updatingAnimal.setType(animal.getType());
        updatingAnimal.setFamily(animal.getFamily());
        updatingAnimal.setGender(animal.getGender());

        Animal updatedAnimal = repository.save(updatingAnimal);
        
        return updatedAnimal;
    }

    public Message delete(Long id) throws Exception {
        
        Animal animal = repository.findById(id).orElseThrow(() -> new AnimalNotFoundException("Animal not found"));

        Long animalId = animal.getId();

        repository.delete(animal);

        Message message = new Message();

        message.setMessage("Animal number " + animalId + " is deleted from the animals table");

        return message;
    }
}