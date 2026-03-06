package com.example.studentmanagement.services;

import java.util.List;
import java.util.UUID;

import com.example.studentmanagement.dtos.student.StudentCreate;
import com.example.studentmanagement.dtos.student.StudentUpdate;
import com.example.studentmanagement.entities.Student;

public interface StudentService {
    Student find(UUID id);

    List<Student> findAll();

    Student create(StudentCreate studentCreate);

    Student update(StudentUpdate studentUpdate, UUID id);

    void delete(UUID id);
}
