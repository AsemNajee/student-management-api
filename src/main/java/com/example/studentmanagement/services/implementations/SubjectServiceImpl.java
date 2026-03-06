package com.example.studentmanagement.services.implementations;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.basecomponents.service.CRUDServiceImpl;
import com.example.studentmanagement.dtos.subject.SubjectCreate;
import com.example.studentmanagement.dtos.subject.SubjectUpdate;
import com.example.studentmanagement.entities.Subject;
import com.example.studentmanagement.mappers.SubjectMapper;
import com.example.studentmanagement.repositories.SubjectRepository;
import com.example.studentmanagement.services.SubjectService;
import com.example.studentmanagement.services.TeacherService;

@Service
public class SubjectServiceImpl
        extends CRUDServiceImpl<Subject, UUID, SubjectCreate, SubjectUpdate, SubjectRepository, SubjectMapper>
        implements SubjectService {

    @Autowired
    private SubjectRepository repo;
    @Autowired
    private TeacherService teacherService;

    @Override
    public Subject create(SubjectCreate studentCreate) {
        var teacher = teacherService.find(studentCreate.teacherId());
        var student = new Subject(
                null,
                studentCreate.name(),
                teacher);
        return repo.save(student);
    }

    @Override
    public Subject update(SubjectUpdate studentUpdate, UUID id) {
        var student = new Subject();
        student.setId(id);
        student.setName(studentUpdate.name());
        if (studentUpdate.teacherId() != null) {
            var teacher = teacherService.find(studentUpdate.teacherId());
            student.setTeacher(teacher);
        }
        return repo.save(student);
    }
}
