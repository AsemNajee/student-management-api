package com.example.studentmanagement.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.basecomponents.controller.CRUDController;
import com.example.studentmanagement.dtos.subject.SubjectCreate;
import com.example.studentmanagement.dtos.subject.SubjectUpdate;
import com.example.studentmanagement.entities.Subject;
import com.example.studentmanagement.services.SubjectService;

@RestController
@RequestMapping("/subjects")
public class SubjectController extends CRUDController<Subject, UUID, SubjectCreate, SubjectUpdate, SubjectService> {}
