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

import com.example.demo.model.Feriado;
import com.example.demo.repository.FeriadoRepository;

@RestController
public class FeriadoController {
    @PostMapping("/feriado")
    public Feriado salvarFeriado(@RequestBody Feriado feriado) {
        return feriadoRepository.save(feriado);
    }

    @GetMapping("/feriado")
    public @ResponseBody Page<Feriado> obterListaFeriados(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "10") String size) {

        Pageable feriado = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
        
        return feriadoRepository.obterListaFeriados(feriado);
    }

    @GetMapping("/feriado/{id}")
    public Feriado obterFeriadoPorId(@PathVariable String id) {
        return feriadoRepository.findById(Integer.valueOf(id)).get();
    }

    @DeleteMapping("/feriado/{id}")
    public String deletarFeriadoPeloId(@PathVariable String id) {
        feriadoRepository.deleteById(Integer.valueOf(id));

        return "Registo deletado com sucesso!";
    }

    @PutMapping("/feriado/{id}")
    public Object atualizarFeriado(
        @PathVariable String id,
        @RequestBody Feriado FeriadoBody) {
            try {
                Feriado feriado = feriadoRepository.findById(Integer.valueOf(id)).get();

                feriado.setDatetime(FeriadoBody.getDatetime());

                feriado.setDescricao(FeriadoBody.getDescricao());
                
                return feriadoRepository.save(feriado);
            } catch (NoSuchElementException e) {
                return "Não há saudação com id " + id;
            }
    }

    @Autowired
    private  FeriadoRepository feriadoRepository;

}
