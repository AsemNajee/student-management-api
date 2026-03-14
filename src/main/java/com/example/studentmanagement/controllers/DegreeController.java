package com.example.studentmanagement.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.dtos.degrees.DegreeCreate;
import com.example.studentmanagement.entities.Degree;
import com.example.studentmanagement.exceptions.GeneralResponse;
import com.example.studentmanagement.services.DegreeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/degrees")
public class DegreeController /* extends CRUDController<Degree, UUID, DegreeCreate, DegreeUpdate, DegreeService> */{
    @Autowired
    private DegreeService service;

    @PostMapping("/{subjectId}")
    public ResponseEntity<GeneralResponse<Degree>> create(@PathVariable UUID subjectId, @Valid @RequestBody DegreeCreate degreeCreate){
        var newEntity = service.create(degreeCreate, subjectId);
        return GeneralResponse.toResponseEntity(newEntity, HttpStatus.OK);
    }

    @GetMapping("/{subjectId}")
    public ResponseEntity<GeneralResponse<List<Degree>>> getAll(@PathVariable UUID subjectId){
        var allEntities = service.findAll(subjectId);
        return GeneralResponse.toResponseEntity(allEntities, HttpStatus.OK);
    }

    @GetMapping("/{subjectId}/{studentId}")
    public ResponseEntity<GeneralResponse<Degree>> getOne(@PathVariable UUID subjectId, @PathVariable UUID studentId){
        var degrees = service.find(subjectId, studentId);
        return GeneralResponse.toResponseEntity(degrees, HttpStatus.OK);
    }
}
