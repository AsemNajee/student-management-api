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
        return new Subject(null,
                dto.fullMark(),
                dto.dailyPresentDegree(),
                dto.behaviorDegree(),
                dto.midTermDegree(),
                dto.finalExamDegree(),
                dto.name(), null);
    }

    @Override
    public Subject toEntity(SubjectUpdate dto, Subject subject) {
        subject.setName(dto.name());
        subject.setFullMark(dto.fullMark());
        subject.setDailyPresentDegree(dto.dailyPresentDegree());
        subject.setBehaviorDegree(dto.behaviorDegree());
        subject.setMidTermDegree(dto.midTermDegree());
        subject.setFinalExamDegree(dto.finalExamDegree());
        return subject;
    }
}
