package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Prospect;;

public interface ProspectRepository extends CrudRepository<Prospect, Integer> {

    Page<Prospect> obterListaProspects (Pageable prospect);

}