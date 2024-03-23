package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.DiaAula;

public interface DiaAulaRepository extends CrudRepository<DiaAula, Integer> {

    Page<DiaAula> obterListaDiasAulas (Pageable diaAula);

}