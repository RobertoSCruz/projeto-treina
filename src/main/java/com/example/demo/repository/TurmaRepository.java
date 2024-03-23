package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Turma;

public interface TurmaRepository extends CrudRepository<Turma, Integer> {

    Page<Turma> obterListaTurma (Pageable turma);

}