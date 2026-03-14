package com.example.studentmanagement.mappers;

import org.springframework.stereotype.Component;

import com.example.studentmanagement.basecomponents.mapper.CRUDMapper;
import com.example.studentmanagement.dtos.student.StudentCreate;
import com.example.studentmanagement.dtos.student.StudentUpdate;
import com.example.studentmanagement.entities.Student;

@Component
public class StudentMapper implements CRUDMapper<Student, StudentCreate, StudentUpdate> {
    @Override
    public Student toEntity(StudentCreate dto) {
        Student student = new Student();
        student.setName(dto.name());
        student.setPhone(dto.phone());
        student.setFatherPhone(dto.fatherPhone());
        student.setDateOfBirth(dto.dateOfBirth());
        student.setDateOfJoin(dto.dateOfJoin());
        return student;
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

    public StudentCreate toCreateDto(Student student) {
        return new StudentCreate(
                student.getName(),
                student.getDateOfBirth(),
                student.getDateOfJoin(),
                student.getPhone(),
                student.getFatherPhone());
    }

    @Override
    public StudentUpdate toUpdateDto(Student entity) {
        return new StudentUpdate(
                entity.getName(),
                entity.getDateOfBirth(),
                entity.getDateOfJoin(),
                entity.getPhone(),
                entity.getFatherPhone());
    }
}
