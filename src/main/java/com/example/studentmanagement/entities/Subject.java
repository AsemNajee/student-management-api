package com.example.studentmanagement.entities;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

    private Double fullPresent;
    private Double fullBehavior;
    private Double fullMidTerm;
    private Double fullFinalExam;

    @ManyToMany
    private List<ClassRoom> classRooms;

    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @ManyToOne
    @JsonManagedReference
    private Teacher teacher;
}
