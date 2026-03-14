package com.example.studentmanagement.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.studentmanagement.basecomponents.service.CRUDServiceImpl;
import com.example.studentmanagement.dtos.degrees.DegreeCreate;
import com.example.studentmanagement.dtos.degrees.DegreeUpdate;
import com.example.studentmanagement.entities.Degree;
import com.example.studentmanagement.entities.Subject;
import com.example.studentmanagement.mappers.DegreeMapper;
import com.example.studentmanagement.repositories.DegreeRepository;
import com.example.studentmanagement.services.DegreeService;

@Service
public class DegreeServiceImpl
        extends CRUDServiceImpl<Degree, UUID, DegreeCreate, DegreeUpdate, DegreeRepository, DegreeMapper>
        implements DegreeService {

    public Degree create(DegreeCreate entityCreate, UUID subjectId) {
        Degree entity = mapper.toEntity(entityCreate);
        var subject = new Subject();
        subject.setId(subjectId);
        entity.setSubject(subject);
        return repo.save(entity);
    }

    public List<Degree> findAll(UUID subjectId) {
        return repo.findAllBySubjectId(subjectId);
    }

    public Degree find(UUID subjectId, UUID studentId) {
        return repo.findBySubjectIdAndStudentId(subjectId, studentId);
    }
}
