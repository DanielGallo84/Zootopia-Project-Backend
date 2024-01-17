package org.vero_slaves.zootopia.controllers;

import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.vero_slaves.zootopia.interfaces.IGenericLimitedService;
import org.vero_slaves.zootopia.models.Gender;
import org.vero_slaves.zootopia.services.GenderService;

@RestController
@RequestMapping(path = "${api-endpoint}/genders")
public class GenderController {

    IGenericLimitedService<Gender> service;

    public GenderController(GenderService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Gender> index() {

        List<Gender> genders = service.getAll();
        return genders;

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Gender> getOneById(@PathVariable("id") Long id) throws Exception {

        Gender gender = service.getById(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(gender);
    }

    @PostMapping(path = "")
    public ResponseEntity<Gender> create(@RequestBody Gender gender) {

        Gender newGender = service.save(gender);

        return ResponseEntity.status(201).body(newGender);
    }
}