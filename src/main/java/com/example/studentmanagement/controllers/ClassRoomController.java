package com.example.studentmanagement.controllers;

import java.util.UUID;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.basecomponents.controller.CRUDController;
import com.example.studentmanagement.dtos.classRoom.ClassRoomCreate;
import com.example.studentmanagement.dtos.classRoom.ClassRoomUpdate;
import com.example.studentmanagement.entities.ClassRoom;
import com.example.studentmanagement.services.ClassRoomService;

@RestController
@RequestMapping("/classes")
public class ClassRoomController extends CRUDController<ClassRoom, UUID, ClassRoomCreate, ClassRoomUpdate, ClassRoomService>{   
}
