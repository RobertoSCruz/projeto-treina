package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Feriado;

public interface FeriadoRepository extends CrudRepository<Feriado, Integer> {

    Page<Feriado> obterListaFeriados (Pageable feriado);

}