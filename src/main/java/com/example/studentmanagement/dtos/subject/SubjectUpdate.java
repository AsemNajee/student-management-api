package com.example.studentmanagement.dtos.subject;

import java.util.UUID;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record SubjectUpdate(
        @Size(min = 2, max = 100, message = "min length of name is 2 chars and max is 100") String name,
        UUID teacherId,
        @Positive Double fullMidTerm,
        @Positive Double fullFinalExam,
        @Positive Double fullBehavior,
        @Positive Double fullPresent) {
}
