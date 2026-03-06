package com.example.studentmanagement.services;

import java.util.UUID;

import com.example.studentmanagement.basecomponents.service.CRUDService;
import com.example.studentmanagement.dtos.teacher.TeacherCreate;
import com.example.studentmanagement.dtos.teacher.TeacherUpdate;
import com.example.studentmanagement.entities.Teacher;

public interface TeacherService extends CRUDService<Teacher, UUID, TeacherCreate, TeacherUpdate> {}
