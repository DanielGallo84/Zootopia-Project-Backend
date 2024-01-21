package org.vero_slaves.zootopia.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.vero_slaves.zootopia.exceptions.AnimalNotFoundException;
import org.vero_slaves.zootopia.exceptions.FamilyNotFoundException;
import org.vero_slaves.zootopia.exceptions.GenderNotFoundException;
import org.vero_slaves.zootopia.exceptions.TypeNotFoundException;
import org.vero_slaves.zootopia.interfaces.IGenericFullService;
import org.vero_slaves.zootopia.messages.Message;
import org.vero_slaves.zootopia.models.Animal;
import org.vero_slaves.zootopia.models.Family;
import org.vero_slaves.zootopia.models.Gender;
import org.vero_slaves.zootopia.models.Type;
import org.vero_slaves.zootopia.repositories.AnimalRepository;
import org.vero_slaves.zootopia.repositories.FamilyRepository;
import org.vero_slaves.zootopia.repositories.GenderRepository;
import org.vero_slaves.zootopia.repositories.TypeRepository;

@Service
public class AnimalService implements IGenericFullService<Animal> {
    
    AnimalRepository repository;
    TypeRepository typeRepository;
    FamilyRepository familyRepository;
    GenderRepository genderRepository;

    public AnimalService(AnimalRepository repository, TypeRepository typeRepository, FamilyRepository familyRepository,
            GenderRepository genderRepository) {
        this.repository = repository;
        this.typeRepository = typeRepository;
        this.familyRepository = familyRepository;
        this.genderRepository = genderRepository;
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

        Type type = typeRepository.findByType(animal.getTypeName()).orElseThrow(() -> new TypeNotFoundException("Type not found"));
        Family family = familyRepository.findByFamily(animal.getFamilyName()).orElseThrow(() -> new FamilyNotFoundException("Family not found"));
        Gender gender = genderRepository.findByGender(animal.getGenderName()).orElseThrow(() -> new GenderNotFoundException("Gender not found"));

        animal.setType(type);
        animal.setFamily(family);
        animal.setGender(gender);

        repository.save(animal);
        return animal;
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