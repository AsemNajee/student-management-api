package com.example.studentmanagement.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.dtos.subject.SubjectCreate;
import com.example.studentmanagement.dtos.subject.SubjectUpdate;
import com.example.studentmanagement.entities.Subject;
import com.example.studentmanagement.exceptions.GeneralResponse;
import com.example.studentmanagement.services.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    @Autowired
    private SubjectService service;

    @GetMapping("/{subjectId}")
    public ResponseEntity<GeneralResponse<Subject>> getOne(@PathVariable UUID subjectId) {
        var subject = service.find(subjectId);
        return GeneralResponse.toResponseEntity(subject, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GeneralResponse<List<Subject>>> getAll() {
        var subjects = service.findAll();
        return GeneralResponse.toResponseEntity(subjects, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GeneralResponse<Subject>> createOne(@RequestBody SubjectCreate subject) {
        var newSubject = service.create(subject);
        return GeneralResponse.toResponseEntity(newSubject, HttpStatus.CREATED);
    }

    @PutMapping("/{subjectId}")
    public ResponseEntity<GeneralResponse<Subject>> updateOne(
            @RequestBody SubjectUpdate subject,
            @PathVariable UUID subjectId) {
        var newSubject = service.update(subject, subjectId);
        return GeneralResponse.toResponseEntity(newSubject, HttpStatus.OK);
    }

    @DeleteMapping("/{subjectId}")
    public ResponseEntity<GeneralResponse<Void>> deleteOne(@PathVariable UUID subjectId) {
        service.delete(subjectId);
        return GeneralResponse.toResponseEntity(HttpStatus.NO_CONTENT);
    }
}
