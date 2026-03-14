package com.example.studentmanagement.dtos.subject;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record SubjectCreate(
        @NotNull @Size(min = 2, max = 100, message = "min length of name is 2 chars and max is 100") String name,
        UUID teacherId,
        // UUID classId,
        @Positive Double fullMidTerm,
        @Positive Double fullFinalExam,
        @Positive Double fullPresent) {
}
