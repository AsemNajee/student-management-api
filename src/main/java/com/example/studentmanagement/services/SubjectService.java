package com.example.studentmanagement.services;

import java.util.UUID;

import com.example.studentmanagement.basecomponents.service.CRUDService;
import com.example.studentmanagement.dtos.subject.SubjectCreate;
import com.example.studentmanagement.dtos.subject.SubjectUpdate;
import com.example.studentmanagement.entities.Subject;

public interface SubjectService extends CRUDService<Subject, UUID, SubjectCreate, SubjectUpdate> {}
