package com.example.studentmanagement.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.basecomponents.controller.CRUDController;
import com.example.studentmanagement.dtos.student.StudentCreate;
import com.example.studentmanagement.dtos.student.StudentUpdate;
import com.example.studentmanagement.entities.Student;
import com.example.studentmanagement.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController extends CRUDController<Student, UUID, StudentCreate, StudentUpdate, StudentService>{}
