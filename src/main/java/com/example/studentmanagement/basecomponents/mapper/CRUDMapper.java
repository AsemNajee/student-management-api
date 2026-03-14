package com.example.studentmanagement.basecomponents.mapper;

/**
 * E : Entity 
 * C : Create Dto
 * U : Update Dto
 * SR : Single Response Dto
 * LR : List Response Dto
 */
public interface CRUDMapper<E, C, U/* , SR, LR*/> {
    E toEntity(C dto);
    E toEntity(U dto, E entity);
    C toCreateDto(E entity);
    U toUpdateDto(E entity);
}
