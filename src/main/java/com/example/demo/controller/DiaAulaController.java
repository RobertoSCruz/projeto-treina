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

import com.example.demo.model.DiaAula;
import com.example.demo.repository.DiaAulaRepository;

@RestController
public class DiaAulaController {
    
    @PostMapping("/diaaula")
    public DiaAula salvarCurso(@RequestBody DiaAula diaaula) {
        return diaAulaRepository.save(diaaula);
    }

    @GetMapping("/diaaula")
    public @ResponseBody Page<DiaAula> obterListaDiasAulas(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "10") String size) {

        Pageable diaAula = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
        
        return diaAulaRepository.obterListaDiasAulas(diaAula);
    }

    @GetMapping("/diaaula")
    public Iterable<DiaAula> obterTodasDiaAula() {
        return diaAulaRepository.findAll();
    }

    @GetMapping("/diaaula/{id}")
    public DiaAula obterDiaAulaPorId(@PathVariable String id) {
        return diaAulaRepository.findById(Integer.valueOf(id)).get();
    }

    @DeleteMapping("/diaaula/{id}")
    public String deletarDiaAulaPeloId(@PathVariable String id) {
        diaAulaRepository.deleteById(Integer.valueOf(id));

        return "Registo deletado com sucesso!";
    }
    @PutMapping("/diaaula/{id}")
    public Object atualizarDiaAula(
        @PathVariable String id,
        @RequestBody DiaAula DiaAulaBody) {
            try {
                DiaAula diaAula = diaAulaRepository.findById(Integer.valueOf(id)).get();

                diaAula.setDataaula(DiaAulaBody.getDataaula());

                diaAula.setTurma_id(DiaAulaBody.getTurma_id());

                diaAula.setSala_id(DiaAulaBody.getSala_id());
               
                return diaAulaRepository.save(diaAula);
            } catch (NoSuchElementException e) {
                return "Não há saudação com id " + id;
            }
    }

    @Autowired
    private  DiaAulaRepository diaAulaRepository;

}
