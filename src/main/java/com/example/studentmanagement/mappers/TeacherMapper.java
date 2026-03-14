package com.example.studentmanagement.mappers;


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

    @Override
    public TeacherCreate toCreateDto(Teacher entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toCreateDto'");
    }

    @Override
    public TeacherUpdate toUpdateDto(Teacher entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toUpdateDto'");
    }
    
}
