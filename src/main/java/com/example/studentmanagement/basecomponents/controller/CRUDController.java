package com.example.studentmanagement.basecomponents.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.studentmanagement.basecomponents.service.CRUDService;
import com.example.studentmanagement.exceptions.GeneralResponse;

import jakarta.validation.Valid;

public abstract class CRUDController<E, K, C, U, S extends CRUDService<E, K, C, U>> {
    @Autowired
    protected S service;

    @GetMapping("/{entityKey}")
    public ResponseEntity<GeneralResponse<E>> getOne(@PathVariable K entityKey) {
        var entity = service.find(entityKey);
        return GeneralResponse.toResponseEntity(entity, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GeneralResponse<List<E>>> getAll() {
        var entitys = service.findAll();
        return GeneralResponse.toResponseEntity(entitys, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GeneralResponse<E>> createOne(@Valid @RequestBody C entity) {
        var newEntity = service.create(entity);
        return GeneralResponse.toResponseEntity(newEntity, HttpStatus.CREATED);
    }

    @PutMapping("/{entityKey}")
    public ResponseEntity<GeneralResponse<E>> updateOne(
            @Valid @RequestBody U entity,
            @PathVariable K entityKey) {
        var newEntity = service.update(entity, entityKey);
        return GeneralResponse.toResponseEntity(newEntity, HttpStatus.OK);
    }

    @DeleteMapping("/{entityKey}")
    public ResponseEntity<GeneralResponse<Void>> deleteOne(@PathVariable K entityKey) {
        service.delete(entityKey);
        return GeneralResponse.toResponseEntity(HttpStatus.NO_CONTENT);
    }
}
