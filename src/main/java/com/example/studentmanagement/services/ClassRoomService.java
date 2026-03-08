package com.example.studentmanagement.services;

import java.util.UUID;

import com.example.studentmanagement.basecomponents.service.CRUDService;
import com.example.studentmanagement.dtos.classRoom.ClassRoomCreate;
import com.example.studentmanagement.dtos.classRoom.ClassRoomUpdate;
import com.example.studentmanagement.entities.ClassRoom;

public interface ClassRoomService extends CRUDService<ClassRoom, UUID, ClassRoomCreate, ClassRoomUpdate> {
    public void linkWithSubject(UUID classId, UUID subjectId);
    public void unLinkWithSubject(UUID classId, UUID subjectId);
    public void linkWithStudent(UUID classId, UUID studentId);
    public void unLinkWithStudent(UUID classId, UUID studentId);
}