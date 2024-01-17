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
import org.vero_slaves.zootopia.models.Family;
import org.vero_slaves.zootopia.services.FamilyService;

@RestController
@RequestMapping(path = "${api-endpoint}/families")
public class FamilyController {

    IGenericLimitedService<Family> service;

    public FamilyController(FamilyService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Family> index() {

        List<Family> families = service.getAll();
        return families;

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Family> getOneById(@PathVariable("id") Long id) throws Exception {

        Family family = service.getById(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(family);
    }

    @PostMapping(path = "")
    public ResponseEntity<Family> create(@RequestBody Family family) {

        Family newFamily = service.save(family);

        return ResponseEntity.status(201).body(newFamily);
    }
}