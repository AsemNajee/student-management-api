package com.example.studentmanagement.entities;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private double fullMark;
    private double dailyPresentDegree;
    private double behaviorDegree;
    private double midTermDegree;
    private double finalExamDegree;

    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @ManyToOne
    @JsonManagedReference
    private Teacher teacher;
}
