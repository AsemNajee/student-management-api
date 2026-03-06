package com.example.studentmanagement.services.implementations;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.dtos.subject.SubjectCreate;
import com.example.studentmanagement.dtos.subject.SubjectUpdate;
import com.example.studentmanagement.entities.Subject;
import com.example.studentmanagement.repositories.SubjectRepository;
import com.example.studentmanagement.repositories.TeacherRepository;
import com.example.studentmanagement.services.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository repo;
    @Autowired
    private TeacherRepository teacherRepo;

    public Subject find(UUID id) {
        var subject = repo.findById(id).orElseThrow();
        return subject;
    }

    public List<Subject> findAll() {
        return repo.findAll();
    }

    public Subject create(SubjectCreate studentCreate) {
        var teacher = teacherRepo.findById(studentCreate.teacherId())
                .orElseThrow(() -> new NoSuchElementException("Teacher not found."));
        var student = new Subject(
                null,
                studentCreate.name(),
                teacher);
        return repo.save(student);
    }

    public Subject update(SubjectUpdate studentUpdate, UUID id) {
        var student = new Subject();
        student.setId(id);
        student.setName(studentUpdate.name());
        if (studentUpdate.teacherId() != null) {
            var teacher = teacherRepo.findById(studentUpdate.teacherId())
                    .orElseThrow(() -> new NoSuchElementException("Teacher not found."));
            student.setTeacher(teacher);
        }
        return repo.save(student);
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
