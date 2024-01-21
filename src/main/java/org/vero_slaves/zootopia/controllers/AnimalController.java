package org.vero_slaves.zootopia.controllers;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vero_slaves.zootopia.interfaces.IGenericFullService;
import org.vero_slaves.zootopia.messages.Message;
import org.vero_slaves.zootopia.models.Animal;
import org.vero_slaves.zootopia.services.AnimalService;


@RestController
@RequestMapping(path = "${api-endpoint}/animals")
public class AnimalController {

    IGenericFullService<Animal> service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Animal> index() {

        List<Animal> animals = service.getAll();
        return animals;

    }

    @GetMapping(path = "/getById/{id}")
    public ResponseEntity<Animal> getOneById(@PathVariable("id") Long id) throws Exception {

        Animal animal = service.getById(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(animal);
    }

    @GetMapping(path = "/getByName/{name}")
    public ResponseEntity<Animal> getOneByName(@PathVariable("name") String name) throws Exception {

        Animal animal = service.getByName(name);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(animal);
    }

    @PostMapping(path = "")
    public ResponseEntity<Animal> create(@RequestBody Animal animal) {

        Animal newAnimal = service.save(animal);

        return ResponseEntity.status(201).body(newAnimal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable("id") Long id, @RequestBody Animal animal) throws Exception {

        Animal updatedAnimal = service.update(id, animal);

        return ResponseEntity.status(200).body(updatedAnimal);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Message> remove(@PathVariable("id") Long id) throws Exception { 

        Message delete = service.delete(id);

        return ResponseEntity.status(200).body(delete);
    }

}

