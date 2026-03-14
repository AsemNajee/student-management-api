package com.example.studentmanagement.mappers;

import org.springframework.stereotype.Component;

import com.example.studentmanagement.basecomponents.mapper.CRUDMapper;
import com.example.studentmanagement.dtos.classRoom.ClassRoomCreate;
import com.example.studentmanagement.dtos.classRoom.ClassRoomUpdate;
import com.example.studentmanagement.entities.ClassRoom;

@Component
public class ClassRoomMapper implements CRUDMapper<ClassRoom, ClassRoomCreate, ClassRoomUpdate>{

    @Override
    public ClassRoom toEntity(ClassRoomCreate dto) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.setName(dto.name());
        return classRoom;
    }

    @Override
    public ClassRoom toEntity(ClassRoomUpdate dto, ClassRoom entity) {
        entity.setName(dto.name());
        return entity;
    }

    @Override
    public ClassRoomCreate toCreateDto(ClassRoom entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toCreateDto'");
    }

    @Override
    public ClassRoomUpdate toUpdateDto(ClassRoom entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toUpdateDto'");
    }
    
}
