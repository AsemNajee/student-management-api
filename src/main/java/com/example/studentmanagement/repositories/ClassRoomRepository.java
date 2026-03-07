package com.example.studentmanagement.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagement.entities.ClassRoom;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, UUID> {
}
