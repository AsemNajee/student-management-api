package com.example.studentmanagement.dtos.degrees;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DegreeUpdate(
        @NotNull UUID studentId,
        @Positive Double present,
        @Positive Double increase,
        @Positive Double decrease,
        @Positive Double midTerm,
        @Positive Double behavior,
        @Positive Double finalExam) {
}
