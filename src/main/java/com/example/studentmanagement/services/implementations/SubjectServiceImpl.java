package com.example.studentmanagement.services.implementations;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.studentmanagement.basecomponents.service.CRUDServiceImpl;
import com.example.studentmanagement.dtos.subject.SubjectCreate;
import com.example.studentmanagement.dtos.subject.SubjectUpdate;
import com.example.studentmanagement.entities.Subject;
import com.example.studentmanagement.mappers.SubjectMapper;
import com.example.studentmanagement.repositories.SubjectRepository;
import com.example.studentmanagement.services.SubjectService;

@Service
public class SubjectServiceImpl
        extends CRUDServiceImpl<Subject, UUID, SubjectCreate, SubjectUpdate, SubjectRepository, SubjectMapper>
        implements SubjectService {
}
