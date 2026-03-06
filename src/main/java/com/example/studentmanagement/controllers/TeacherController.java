package com.example.studentmanagement.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.basecomponents.controller.CRUDController;
import com.example.studentmanagement.dtos.teacher.TeacherCreate;
import com.example.studentmanagement.dtos.teacher.TeacherUpdate;
import com.example.studentmanagement.entities.Teacher;
import com.example.studentmanagement.services.TeacherService;

@RestController
@RequestMapping("/teachers")
public class TeacherController extends CRUDController<Teacher, UUID, TeacherCreate, TeacherUpdate, TeacherService>{}
