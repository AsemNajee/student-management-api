package com.example.studentmanagement.mappers;

import org.springframework.stereotype.Component;

import com.example.studentmanagement.basecomponents.mapper.CRUDMapper;
import com.example.studentmanagement.dtos.subject.SubjectCreate;
import com.example.studentmanagement.dtos.subject.SubjectUpdate;
import com.example.studentmanagement.entities.Subject;

@Component
public class SubjectMapper implements CRUDMapper<Subject, SubjectCreate, SubjectUpdate> {

    @Override
    public Subject toEntity(SubjectCreate dto) {
        Subject subject = new Subject();
        subject.setName(dto.name());
        subject.setFullFinalExam(dto.fullFinalExam());
        subject.setFullMidTerm(dto.fullMidTerm());
        subject.setFullPresent(dto.fullPresent());
        return subject;
    }

    @Override
    public Subject toEntity(SubjectUpdate dto, Subject subject) {
        subject.setName(dto.name());
        return subject;
    }

    @Override
    public SubjectCreate toCreateDto(Subject entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toCreateDto'");
    }

    @Override
    public SubjectUpdate toUpdateDto(Subject entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toUpdateDto'");
    }
}
