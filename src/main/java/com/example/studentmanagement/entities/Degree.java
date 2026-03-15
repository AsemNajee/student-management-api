package com.example.studentmanagement.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Degree {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private Student student;

    @ManyToOne
    private Subject subject;

    @Positive
    private Double present;
    @Positive
    private Double increase;
    @Positive
    private Double decrease;
    @Positive
    private Double midTerm;
    @Positive
    private Double finalExam;
    @Positive
    private Double behavior;
}