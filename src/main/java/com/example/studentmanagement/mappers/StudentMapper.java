package com.example.studentmanagement.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.studentmanagement.basecomponents.mapper.CRUDMapper;
import com.example.studentmanagement.dtos.student.StudentCreate;
import com.example.studentmanagement.dtos.student.StudentUpdate;
import com.example.studentmanagement.entities.Student;

@Component
public class StudentMapper implements CRUDMapper<Student, StudentCreate, StudentUpdate> {
    @Override
    public Student toEntity(StudentCreate dto) {
        return new Student(
                null,
                dto.name(),
                dto.phone(),
                dto.fatherPhone(),
                dto.dateOfBirth(),
                dto.dateOfJoin());
    }

    @Override
    public Student toEntity(StudentUpdate dto, Student student) {
        student.setName(dto.name());
        student.setPhone(dto.phone());
        student.setFatherPhone(dto.fatherPhone());
        student.setDateOfBirth(dto.dateOfBirth());
        student.setDateOfJoin(dto.dateOfJoin());
        return student;
    }
}
