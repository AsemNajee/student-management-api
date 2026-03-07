package com.example.studentmanagement.services.implementations;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.studentmanagement.basecomponents.service.CRUDServiceImpl;
import com.example.studentmanagement.dtos.classRoom.ClassRoomCreate;
import com.example.studentmanagement.dtos.classRoom.ClassRoomUpdate;
import com.example.studentmanagement.entities.ClassRoom;
import com.example.studentmanagement.mappers.ClassRoomMapper;
import com.example.studentmanagement.repositories.ClassRoomRepository;
import com.example.studentmanagement.services.ClassRoomService;

@Service
public class ClassRoomServiceImpl
        extends CRUDServiceImpl<ClassRoom, UUID, ClassRoomCreate, ClassRoomUpdate, ClassRoomRepository, ClassRoomMapper>
        implements ClassRoomService {
}
