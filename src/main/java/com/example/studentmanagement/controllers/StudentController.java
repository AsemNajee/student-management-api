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

import com.example.studentmanagement.dtos.student.StudentCreate;
import com.example.studentmanagement.dtos.student.StudentUpdate;
import com.example.studentmanagement.entities.Student;
import com.example.studentmanagement.exceptions.GeneralResponse;
import com.example.studentmanagement.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @GetMapping("/{studentId}")
    public ResponseEntity<GeneralResponse<Student>> getOne(@PathVariable UUID studentId) {
        var student = service.find(studentId);
        return GeneralResponse.toResponseEntity(student, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<GeneralResponse<List<Student>>> getAll() {
        var students = service.findAll();
        return GeneralResponse.toResponseEntity(students, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GeneralResponse<Student>> createOne(@RequestBody StudentCreate student) {
        var newStudent = service.create(student);
        return GeneralResponse.toResponseEntity(newStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<GeneralResponse<Student>> updateOne(
            @RequestBody StudentUpdate student,
            @PathVariable UUID studentId) {
        var newStudent = service.update(student, studentId);
        return GeneralResponse.toResponseEntity(newStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<GeneralResponse<Void>> deleteOne(@PathVariable UUID studentId) {
        service.delete(studentId);
        return GeneralResponse.toResponseEntity(HttpStatus.NO_CONTENT);
    }
}
