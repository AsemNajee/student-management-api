package com.example.studentmanagement.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagement.entities.Degree;

public interface DegreeRepository extends JpaRepository<Degree, UUID> {
    List<Degree> findAllBySubjectId(UUID subjectId);
    Degree findBySubjectIdAndStudentId(UUID subjectId, UUID studentId);
}
