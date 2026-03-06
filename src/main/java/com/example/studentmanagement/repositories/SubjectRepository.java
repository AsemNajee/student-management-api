package com.example.studentmanagement.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.studentmanagement.entities.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, UUID>{}
