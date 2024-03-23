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

import com.example.demo.model.Turma;
import com.example.demo.repository.TurmaRepository;

@RestController
public class TurmaController {
    
    @PostMapping("/turma")
    public Turma salvarTurma(@RequestBody Turma turma) {
        return turmaRepository.save(turma);
    } 

    @GetMapping("/turma")
    public @ResponseBody Page<Turma> obterListaTurma(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "10") String size) {

        Pageable turma = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
        
        return turmaRepository.obterListaTurma(turma);
    }

    @GetMapping("/turma/{id}")
    public Turma obterTurmaPorId(@PathVariable String id) {
        return turmaRepository.findById(Integer.valueOf(id)).get();
    }

    @DeleteMapping("/turma/{id}")
    public String deletarTurmaPeloId(@PathVariable String id) {
        turmaRepository.deleteById(Integer.valueOf(id));

        return "Registo deletado com sucesso!";
    }

    @PutMapping("/turma/{id}")
    public Object atualizarTurma(
        @PathVariable String id,
        @RequestBody Turma TurmaBody) {
            try {
                Turma turma = turmaRepository.findById(Integer.valueOf(id)).get();

                turma.setValor(TurmaBody.getValor());

                turma.setTurno(TurmaBody.getTurno());

                turma.setSeg(TurmaBody.getSeg());
                
                turma.setTer(TurmaBody.getTer());

                turma.setQua(TurmaBody.getQua());

                turma.setQui(TurmaBody.getQui());

                turma.setSex(TurmaBody.getSex());

                turma.setSab(TurmaBody.getSab());

                //turma.setProfessor_id(TurmaBody.getProfessor_id());

                //turma.setCurso_id(TurmaBody.getCurso_id());
                return turmaRepository.save(turma);
            } catch (NoSuchElementException e) {
                return "Não há saudação com id " + id;
            }
    }

    @Autowired
    private  TurmaRepository turmaRepository;

}