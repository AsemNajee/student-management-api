package com.example.studentmanagement.dtos;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public record OnlyUUIDDto(
        @NotNull UUID id) {
}
