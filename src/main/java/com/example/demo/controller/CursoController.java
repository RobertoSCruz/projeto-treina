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

import com.example.demo.model.Curso;
import com.example.demo.repository.CursoRepository;

@RestController
public class CursoController {

    @PostMapping("/curso")
    public Curso salvarCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @GetMapping("/curso")
    public @ResponseBody Page<Curso> obterListaCursos(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "10") String size) {

        Pageable curso = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
        
        return cursoRepository.obterListaCursos(curso);
    }

    @GetMapping("/curso")
    public Iterable<Curso> obterTodasCurso() {
        return cursoRepository.findAll();
    }

    @GetMapping("/curso/{id}")
    public Curso obterCursoPorId(@PathVariable String id) {
        return cursoRepository.findById(Integer.valueOf(id)).get();
    }

    @DeleteMapping("/curso/{id}")
    public String deletarCursoPeloId(@PathVariable String id) {
        cursoRepository.deleteById(Integer.valueOf(id));

        return "Registo deletado com sucesso!";
    }

    @PutMapping("/curso/{id}")
    public Object atualizarCurso(
        @PathVariable String id,
        @RequestBody Curso CursoBody) {
            try {
                Curso curso = cursoRepository.findById(Integer.valueOf(id)).get();
                
                curso.setNome(CursoBody.getNome());

                curso.setChaula(CursoBody.getChaula());

                curso.setChtotal(CursoBody.getChtotal());

                return cursoRepository.save(curso);
            } catch (NoSuchElementException e) {
                return "Não há saudação com id " + id;
            }
    }
    
    @Autowired
    private  CursoRepository cursoRepository;
}
