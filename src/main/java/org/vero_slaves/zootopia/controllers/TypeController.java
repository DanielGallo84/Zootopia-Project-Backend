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
import org.vero_slaves.zootopia.models.Type;
import org.vero_slaves.zootopia.services.TypeService;

@RestController
@RequestMapping(path = "${api-endpoint}/types")
public class TypeController {

    IGenericLimitedService<Type> service;

    public TypeController(TypeService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<Type> index() {

        List<Type> types = service.getAll();
        return types;

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Type> getOneById(@PathVariable("id") Long id) throws Exception {

        Type type = service.getById(id);

        return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(type);
    }

    @PostMapping(path = "")
    public ResponseEntity<Type> create(@RequestBody Type type) {

        Type newType = service.save(type);

        return ResponseEntity.status(201).body(newType);
    }
}
