package com.example.studentmanagement.dtos.degrees;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record DegreeCreate(
        @NotNull UUID studentId,
        @NotNull @Positive Double present,
        @Positive Double increase,
        @Positive Double decrease,
        @NotNull @Positive Double midTerm,
        @NotNull @Positive Double behavior,
        @NotNull @Positive Double finalExam) {
}