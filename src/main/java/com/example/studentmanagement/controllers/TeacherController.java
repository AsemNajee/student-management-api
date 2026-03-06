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

import com.example.studentmanagement.dtos.teacher.TeacherCreate;
import com.example.studentmanagement.dtos.teacher.TeacherUpdate;
import com.example.studentmanagement.entities.Teacher;
import com.example.studentmanagement.exceptions.GeneralResponse;
import com.example.studentmanagement.services.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService service;

    @GetMapping("/{teacherId}")
    public ResponseEntity<GeneralResponse<Teacher>> getOne(@PathVariable UUID teacherId) {
        var teacher = service.find(teacherId);
        return GeneralResponse.toResponseEntity(teacher, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GeneralResponse<List<Teacher>>> getAll() {
        var teachers = service.findAll();
        // return new ResponseEntity<>(new GeneralResponse<>(teachers), HttpStatus.OK);
        // return new GeneralResponse<>(teachers).toResponseEntity(HttpStatus.OK);
        return GeneralResponse.toResponseEntity(teachers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GeneralResponse<Teacher>> createOne(@RequestBody TeacherCreate teacher) {
        var newTeacher = service.create(teacher);
        return GeneralResponse.toResponseEntity(newTeacher, HttpStatus.CREATED);
    }

    @PutMapping("/{teacherId}")
    public ResponseEntity<GeneralResponse<Teacher>> updateOne(
            @RequestBody TeacherUpdate teacher,
            @PathVariable UUID teacherId) {
        var newTeacher = service.update(teacher, teacherId);
        return GeneralResponse.toResponseEntity(newTeacher, HttpStatus.OK);
    }

    @DeleteMapping("/{teacherId}")
    public ResponseEntity<GeneralResponse<Void>> deleteOne(@PathVariable UUID teacherId) {
        service.delete(teacherId);
        return GeneralResponse.toResponseEntity(HttpStatus.NO_CONTENT);
    }
}
