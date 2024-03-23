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

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;


@RestController
public class AlunoController {

    @PostMapping("/aluno")
    public Aluno salvarAluno(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @GetMapping("/aluno")
    public @ResponseBody Page<Aluno> obterListaAlunos(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "10") String size) {

        Pageable aluno = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
        
        return alunoRepository.obterListaAlunos(aluno);
    }

    public Iterable<Aluno> obterTodasAluno() {
        return alunoRepository.findAll();
    }

    @GetMapping("/aluno/{id}")
    public Aluno obterAlunoPorId(@PathVariable String id) {
        return alunoRepository.findById(Integer.valueOf(id)).get();
    }

    @DeleteMapping("/aluno/{id}")
    public String deletarAlunoPeloId(@PathVariable String id) {
        alunoRepository.deleteById(Integer.valueOf(id));

        return "Registo deletado com sucesso!";
    }

    @PutMapping("/aluno/{id}")
    public Object atualizarAluno(
        @PathVariable String id,
        @RequestBody Aluno AlunoBody) {
            try {
                Aluno aluno = alunoRepository.findById(Integer.valueOf(id)).get();
                
                aluno.setNome(AlunoBody.getNome());

                aluno.setCpf(AlunoBody.getCpf());

                aluno.setEmail(AlunoBody.getEmail());

                aluno.setTelefone(AlunoBody.getTelefone());

                aluno.setEndereco(AlunoBody.getEndereco());

                return alunoRepository.save(aluno);
            } catch (NoSuchElementException e) {
                return "Não há saudação com id " + id;
            }
    }

    @Autowired
    private  AlunoRepository alunoRepository;

}
