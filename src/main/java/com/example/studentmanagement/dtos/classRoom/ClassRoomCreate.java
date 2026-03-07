package com.example.studentmanagement.dtos.classRoom;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClassRoomCreate(
        @NotNull @Size(min = 2, max = 100) String name) {
}
