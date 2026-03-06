package com.example.studentmanagement.services.implementations;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.dtos.student.StudentCreate;
import com.example.studentmanagement.dtos.student.StudentUpdate;
import com.example.studentmanagement.entities.Student;
import com.example.studentmanagement.repositories.StudentRepository;
import com.example.studentmanagement.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repo;

    public Student find(UUID id){
        var student = repo.findById(id).orElseThrow();
        return student;
    }

    public List<Student> findAll(){
        return repo.findAll();
    }

    public Student create(StudentCreate studentCreate){
        var student = new Student(
            null, 
            studentCreate.name(),
            studentCreate.dateOfBirth(),
            studentCreate.dateOfJoin()
        );

        return repo.save(student);
    }

    public Student update(StudentUpdate studentUpdate, UUID id){
        var student = new Student();
        student.setId(id);
        student.setName(studentUpdate.name());
        return repo.save(student);
    }

    public void delete(UUID id){
        repo.deleteById(id);
    }
}
