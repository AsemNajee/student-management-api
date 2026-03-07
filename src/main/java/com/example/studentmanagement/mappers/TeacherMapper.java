package com.example.studentmanagement.mappers;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.example.studentmanagement.basecomponents.mapper.CRUDMapper;
import com.example.studentmanagement.dtos.teacher.TeacherCreate;
import com.example.studentmanagement.dtos.teacher.TeacherUpdate;
import com.example.studentmanagement.entities.Teacher;

@Component
public class TeacherMapper implements CRUDMapper<Teacher, TeacherCreate, TeacherUpdate>{

    @Override
    public Teacher toEntity(TeacherCreate dto) {
        return new Teacher(null, dto.name(), null);
    }

    @Override
    public Teacher toEntity(TeacherUpdate dto, Teacher teacher) {
        teacher.setName(dto.name());
        return teacher;
    }
    
}
