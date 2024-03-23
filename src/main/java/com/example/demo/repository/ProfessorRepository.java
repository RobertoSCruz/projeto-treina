package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

    Page<Professor> obterListaProfessores (Pageable professor);

}
