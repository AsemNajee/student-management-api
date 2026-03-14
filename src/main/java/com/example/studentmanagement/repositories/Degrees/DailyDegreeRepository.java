package com.example.studentmanagement.repositories.Degrees;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagement.entities.degrees.DailyDegree;

public interface DailyDegreeRepository extends JpaRepository<DailyDegree, UUID>{
}
