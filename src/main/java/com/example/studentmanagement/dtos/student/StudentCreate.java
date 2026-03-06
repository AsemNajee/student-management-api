package com.example.studentmanagement.dtos.student;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public record StudentCreate(
        @NotNull @Size(min = 2, max = 100, message = "min length of name is 2 chars and max is 100") String name,

        @Past(message = "date of birth must be in past") LocalDate dateOfBirth,

        @PastOrPresent(message = "date of birth must be in past") LocalDate dateOfJoin) {

}
