package com.example.studentmanagement.services.implementations;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.studentmanagement.basecomponents.service.CRUDServiceImpl;
import com.example.studentmanagement.dtos.student.StudentCreate;
import com.example.studentmanagement.dtos.student.StudentUpdate;
import com.example.studentmanagement.entities.Student;
import com.example.studentmanagement.mappers.StudentMapper;
import com.example.studentmanagement.repositories.StudentRepository;
import com.example.studentmanagement.services.StudentService;

@Service
public class StudentServiceImpl
        extends CRUDServiceImpl<Student, UUID, StudentCreate, StudentUpdate, StudentRepository, StudentMapper>
        implements StudentService {
}
