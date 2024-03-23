package com.example.demo.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Professor;
import com.example.demo.repository.ProfessorRepository;

@RestController
public class ProfessorController {

    @PostMapping("/professor")
    public Professor salvarProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @GetMapping("/professor")
    public @ResponseBody Page<Professor> obterListaProfessores(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "10") String size) {

        Pageable professor = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
        
        return professorRepository.obterListaProfessores(professor);
    }
  

    @GetMapping("/professor/{id}")
    public Professor obterProfessorPorId(@PathVariable String id) {
        return professorRepository.findById(Integer.valueOf(id)).get();
    }

    @DeleteMapping("/professor/{id}")
    public String deletarProfessorPeloId(@PathVariable String id) {
        professorRepository.deleteById(Integer.valueOf(id));

        return "Registo deletado com sucesso!";
    }

    @PutMapping("/professor/{id}")
    public Object atualizarProfessor(
        @PathVariable String id,
        @RequestBody Professor ProfessorBody) {
            try {
                Professor professor = professorRepository.findById(Integer.valueOf(id)).get();
                
                professor.setNome(ProfessorBody.getNome());

                professor.setEmail(ProfessorBody.getEmail());

                professor.setTelefone(ProfessorBody.getTelefone());

                professor.setValorhoraaula(ProfessorBody.getValorhoraaula());

                return professorRepository.save(professor);
            } catch (NoSuchElementException e) {
                return "Não há saudação com id " + id;
            }
    }

    @Autowired
    private  ProfessorRepository professorRepository;

}
