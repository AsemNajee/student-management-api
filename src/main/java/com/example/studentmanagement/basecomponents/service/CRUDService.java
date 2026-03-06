package com.example.studentmanagement.basecomponents.service;

import java.util.List;

/**
 * </br>
 * E : the entity class</br>
 * K : the key class</br>
 * C : create dto</br>
 * U : update dto</br>
 */
public interface CRUDService<E, K, C, U> {
    E find(K key);

    List<E> findAll();

    E create(C createDto);

    E update(U updateDto, K key);

    void delete(K key);
}
