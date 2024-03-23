package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Curso;


public interface CursoRepository extends CrudRepository<Curso, Integer> {

    Page<Curso> obterListaCursos (Pageable curso);
    
}
