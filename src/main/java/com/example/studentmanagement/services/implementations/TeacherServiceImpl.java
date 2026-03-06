package com.example.studentmanagement.services.implementations;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.studentmanagement.basecomponents.service.CRUDServiceImpl;
import com.example.studentmanagement.dtos.teacher.TeacherCreate;
import com.example.studentmanagement.dtos.teacher.TeacherUpdate;
import com.example.studentmanagement.entities.Teacher;
import com.example.studentmanagement.mappers.TeacherMapper;
import com.example.studentmanagement.repositories.TeacherRepository;
import com.example.studentmanagement.services.TeacherService;

@Service
public class TeacherServiceImpl
        extends CRUDServiceImpl<Teacher, UUID, TeacherCreate, TeacherUpdate, TeacherRepository, TeacherMapper>
        implements TeacherService {
}
