package com.example.studentmanagement.services;

import java.util.List;
import java.util.UUID;

import com.example.studentmanagement.dtos.subject.SubjectCreate;
import com.example.studentmanagement.dtos.subject.SubjectUpdate;
import com.example.studentmanagement.entities.Subject;

public interface SubjectService {
    Subject find(UUID id);

    List<Subject> findAll();

    Subject create(SubjectCreate subjectCreate);

    Subject update(SubjectUpdate subjectUpdate, UUID id);

    void delete(UUID id);
}
