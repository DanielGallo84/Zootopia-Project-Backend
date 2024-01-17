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
import org.vero_slaves.zootopia.interfaces.IGenericService;
import org.vero_slaves.zootopia.messages.Message;
import org.vero_slaves.zootopia.models.Animal;
import org.vero_slaves.zootopia.services.AnimalService;


@RestController
@RequestMapping(path = "${api-endpoint}/tickets")
public class AnimalController {

    IGenericService<Animal> service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Animal> index() {

        List<Animal> tickets = service.getAll();
        return tickets;

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Animal> getOneById(@PathVariable("id") Long id) throws Exception {

        Animal ticket = service.getById(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(ticket);
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Animal> getOneByName(@PathVariable("name") String name) throws Exception {

        Animal ticket = service.getByName(name);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(ticket);
    }

    @PostMapping(path = "")
    public ResponseEntity<Animal> create(@RequestBody Animal ticket) {

        Animal newAnimal = service.save(ticket);

        return ResponseEntity.status(201).body(newAnimal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable("id") Long id, @RequestBody Animal ticket) throws Exception {

        Animal updatedAnimal = service.update(id, ticket);

        return ResponseEntity.status(200).body(updatedAnimal);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Message> remove(@PathVariable("id") Long id) throws Exception { 

        Message delete = service.delete(id);

        return ResponseEntity.status(200).body(delete);
    }

}

