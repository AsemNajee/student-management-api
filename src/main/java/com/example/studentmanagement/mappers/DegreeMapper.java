package com.example.studentmanagement.mappers;

import org.springframework.stereotype.Component;

import com.example.studentmanagement.basecomponents.mapper.CRUDMapper;
import com.example.studentmanagement.dtos.degrees.DegreeCreate;
import com.example.studentmanagement.dtos.degrees.DegreeUpdate;
import com.example.studentmanagement.entities.Degree;
import com.example.studentmanagement.entities.Student;

@Component
public class DegreeMapper implements CRUDMapper<Degree, DegreeCreate, DegreeUpdate> {

    @Override
    public Degree toEntity(DegreeCreate dto) {
        Degree degree = new Degree();
        Student student = new Student();
        student.setId(dto.studentId());
        degree.setStudent(student);
        degree.setPresent(dto.present());
        degree.setDecrease(dto.decrease());
        degree.setIncrease(dto.increase());
        degree.setBehavior(dto.behavior());
        degree.setMidTerm(dto.midTerm());
        degree.setFinalExam(dto.finalExam());
        return degree;
    }
    
    @Override
    public Degree toEntity(DegreeUpdate dto, Degree entity) {
        Student student = new Student();
        student.setId(dto.studentId());
        entity.setStudent(student);
        if(dto.behavior() != null){
            entity.setBehavior(dto.behavior());
        }
        if (dto.midTerm() != null) {
            entity.setMidTerm(dto.midTerm());
        }
        if (dto.finalExam() != null) {
            entity.setFinalExam(dto.finalExam());
        }
        if (dto.present() != null) {
            entity.setPresent(dto.present());
        }
        if(dto.increase() != null){
            entity.setIncrease(dto.increase());
        }
        if(dto.decrease() != null){
            entity.setDecrease(dto.decrease());
        }
        return entity;
    }

    @Override
    public DegreeCreate toCreateDto(Degree entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toCreateDto'");
    }

    @Override
    public DegreeUpdate toUpdateDto(Degree entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toUpdateDto'");
    }

}
