package com.example.studentmanagement.services;

import java.util.List;
import java.util.UUID;

import com.example.studentmanagement.dtos.teacher.TeacherCreate;
import com.example.studentmanagement.dtos.teacher.TeacherUpdate;
import com.example.studentmanagement.entities.Teacher;

public interface TeacherService {
    Teacher find(UUID id);

    List<Teacher> findAll();

    Teacher create(TeacherCreate teacherCreate);

    Teacher update(TeacherUpdate teacherUpdate, UUID id);

    void delete(UUID id);
}
