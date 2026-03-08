package com.example.studentmanagement.basecomponents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.studentmanagement.basecomponents.mapper.CRUDMapper;

public abstract class CRUDServiceImpl<E, K, C, U, R extends JpaRepository<E, K>, M extends CRUDMapper<E, C, U>> {
    
    @Autowired
    protected R repo;
    @Autowired
    protected M mapper;

    public E find(K key){
        var entity = repo.findById(key).orElseThrow();
        return entity;
    }

    public List<E> findAll(){
        return repo.findAll();
    }

    public E create(C entityCreate){
        E entity = mapper.toEntity(entityCreate);
        return repo.save(entity);
    }

    public E update(U entityUpdate, K key){
        E entity = find(key);
        entity = mapper.toEntity(entityUpdate, entity);
        return repo.save(entity);
    }

    public void delete(K key){
        repo.deleteById(key);
    }
}
