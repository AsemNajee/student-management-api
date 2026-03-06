package com.example.studentmanagement.dtos.student;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record StudentUpdate(
    @NotNull @Size(min = 2, max = 100, message = "min length of name is 2 chars and max is 100") String name
) {
}
