package com.example.studentmanagement.mappers;

import java.util.UUID;

import com.example.studentmanagement.basecomponents.mapper.CRUDMapper;
import com.example.studentmanagement.dtos.teacher.TeacherCreate;
import com.example.studentmanagement.dtos.teacher.TeacherUpdate;
import com.example.studentmanagement.entities.Teacher;

public class TeacherMapper implements CRUDMapper<Teacher, UUID, TeacherCreate, TeacherUpdate>{

    @Override
    public Teacher toEntity(TeacherCreate dto) {
        return new Teacher(null, dto.name(), null);
    }

    @Override
    public Teacher toEntity(TeacherUpdate dto, UUID key) {
        return new Teacher(key, dto.name(), null);
    }
    
}
