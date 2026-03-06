package com.example.studentmanagement.services;

import java.util.UUID;

import com.example.studentmanagement.basecomponents.service.CRUDService;
import com.example.studentmanagement.dtos.student.StudentCreate;
import com.example.studentmanagement.dtos.student.StudentUpdate;
import com.example.studentmanagement.entities.Student;

public interface StudentService extends CRUDService<Student, UUID, StudentCreate, StudentUpdate> {}
