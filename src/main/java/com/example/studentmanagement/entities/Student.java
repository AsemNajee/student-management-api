package com.example.studentmanagement.entities;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @Size(min = 2, max = 100, message = "min length of name is 2 chars and max is 100")
    private String name;

    private String phone;
    private String fatherPhone;
    @ManyToOne
    private ClassRoom classRoom;
    // private List<Subject> subjects;

    @Past(message = "date of birth must be in past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @PastOrPresent(message = "date of birth must be in past")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfJoin;
}
