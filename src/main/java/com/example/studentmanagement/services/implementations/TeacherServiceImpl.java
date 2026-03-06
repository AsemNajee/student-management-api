package com.example.studentmanagement.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.dtos.teacher.TeacherCreate;
import com.example.studentmanagement.dtos.teacher.TeacherUpdate;
import com.example.studentmanagement.entities.Teacher;
import com.example.studentmanagement.repositories.TeacherRepository;
import com.example.studentmanagement.services.TeacherService;


@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    private TeacherRepository repo;

    public Teacher find(UUID id){
        var student = repo.findById(id).orElseThrow();
        return student;
    }

    public List<Teacher> findAll(){
        return repo.findAll();
    }

    public Teacher create(TeacherCreate teacherCreate){
        var teacher = new Teacher(
            null,
            teacherCreate.name(),
            null
        );

        return repo.save(teacher);
    }

    public Teacher update(TeacherUpdate teacherUpdate, UUID id){
        var teacher = new Teacher();
        teacher.setId(id);
        teacher.setName(teacherUpdate.name());
        return repo.save(teacher);
    }

    public void delete(UUID id){
        repo.deleteById(id);
    }
}
