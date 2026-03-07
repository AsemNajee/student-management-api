package com.example.studentmanagement.basecomponents.mapper;

public interface CRUDMapper<E, C, U> {
    E toEntity(C dto);
    // E toEntity(U dto, K key);
    E toEntity(U dto, E entity);
}
