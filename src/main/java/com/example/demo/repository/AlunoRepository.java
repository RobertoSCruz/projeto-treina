package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

    Page<Aluno> obterListaAlunos (Pageable aluno);
}