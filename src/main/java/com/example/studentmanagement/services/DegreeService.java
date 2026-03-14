package com.example.studentmanagement.services;

import java.util.List;
import java.util.UUID;

import com.example.studentmanagement.basecomponents.service.CRUDService;
import com.example.studentmanagement.dtos.degrees.DegreeCreate;
import com.example.studentmanagement.dtos.degrees.DegreeUpdate;
import com.example.studentmanagement.entities.Degree;

public interface DegreeService extends CRUDService<Degree, UUID, DegreeCreate, DegreeUpdate> {
    List<Degree> findAll(UUID subjectId);
    Degree find(UUID subjectId, UUID studentId);
    Degree create(DegreeCreate degreeCreate, UUID subjectId);
}
