package com.example.studentmanagement.mappers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.studentmanagement.basecomponents.mapper.CRUDMapper;
import com.example.studentmanagement.dtos.subject.SubjectCreate;
import com.example.studentmanagement.dtos.subject.SubjectUpdate;
import com.example.studentmanagement.entities.Subject;
import com.example.studentmanagement.services.TeacherService;

@Component
public class SubjectMapper implements CRUDMapper<Subject, UUID, SubjectCreate, SubjectUpdate> {

    @Autowired
    private TeacherService teacherService;

    @Override
    public Subject toEntity(SubjectCreate dto) {
        var teacher = teacherService.find(dto.teacherId());
        return new Subject(
                null,
                dto.name(),
                teacher);
    }

    @Override
    public Subject toEntity(SubjectUpdate dto, UUID key) {
        var teacher = teacherService.find(dto.teacherId());
        return new Subject(
                key,
                dto.name(),
                teacher);
    }
}
