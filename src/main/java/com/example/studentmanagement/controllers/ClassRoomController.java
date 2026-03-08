package com.example.studentmanagement.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.basecomponents.controller.CRUDController;
import com.example.studentmanagement.dtos.OnlyUUIDDto;
import com.example.studentmanagement.dtos.classRoom.ClassRoomCreate;
import com.example.studentmanagement.dtos.classRoom.ClassRoomUpdate;
import com.example.studentmanagement.entities.ClassRoom;
import com.example.studentmanagement.exceptions.GeneralResponse;
import com.example.studentmanagement.services.ClassRoomService;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/classes")
public class ClassRoomController extends CRUDController<ClassRoom, UUID, ClassRoomCreate, ClassRoomUpdate, ClassRoomService>{   
    
    @PostMapping("/{classId}/subjects")
    public ResponseEntity<GeneralResponse<Void>> linkWithSubject(@PathVariable UUID classId, @Valid @RequestBody OnlyUUIDDto subjectDto) {
        service.linkWithSubject(classId, subjectDto.id());
        return GeneralResponse.toResponseEntity(HttpStatus.OK);
    }
    
    @PostMapping("/{classId}/students")
    public ResponseEntity<GeneralResponse<Void>> linkWithStudent(@PathVariable UUID classId, @Valid @RequestBody OnlyUUIDDto studentDto) {
        service.linkWithStudent(classId, studentDto.id());
        return GeneralResponse.toResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{classId}/students/{studentId}")
    public ResponseEntity<GeneralResponse<Void>> unLinkWithStudent(@PathVariable UUID classId, @Valid @PathVariable UUID studentId) {
        service.unLinkWithStudent(classId, studentId);
        return GeneralResponse.toResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{classId}/subject/{subjectId}")
    public ResponseEntity<GeneralResponse<Void>> unLinkWithSubject(@PathVariable UUID classId, @Valid @PathVariable UUID subjectId) {
        service.unLinkWithSubject(classId, subjectId);
        return GeneralResponse.toResponseEntity(HttpStatus.OK);
    }
}
