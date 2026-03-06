package com.example.studentmanagement.basecomponents.mapper;

public interface CRUDMapper<E, K, C, U> {
    E toEntity(C dto);
    E toEntity(U dto, K key);
}
