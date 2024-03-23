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

import com.example.demo.model.Prospect;
import com.example.demo.repository.ProspectRepository;

@RestController
public class ProspectController {
	
    @PostMapping("/prospect")
    public Prospect salvarProspect(@RequestBody Prospect prospect) {
        return prospectRepository.save(prospect);
    }

    @GetMapping("/prospect")
    public @ResponseBody Page<Prospect> obterListaProspects(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "10") String size) {

        Pageable prospect = PageRequest.of(Integer.parseInt(page), Integer.parseInt(size));
        
        return prospectRepository.obterListaProspects(prospect);
    }

    @GetMapping("/prospect/{id}")
    public Prospect obterProspectPorId(@PathVariable String id) {
        return prospectRepository.findById(Integer.valueOf(id)).get();
    }

    @DeleteMapping("/prospect/{id}")
    public String deletarProspectPeloId(@PathVariable String id) {
        prospectRepository.deleteById(Integer.valueOf(id));

        return "Registo deletado com sucesso!";
    }

    @PutMapping("/prospect/{id}")
    public Object atualizarProspect(
        @PathVariable String id,
        @RequestBody Prospect ProspectBody) {
            try {
                Prospect prospect = prospectRepository.findById(Integer.valueOf(id)).get();
                
                prospect.setNome(ProspectBody.getNome());

                prospect.setTelefone(ProspectBody.getTelefone());

                prospect.setStatus(ProspectBody.getStatus());

                prospect.setDatacadastro(ProspectBody.getDatacadastro());

                prospect.setDatanovocontrato(ProspectBody.getDatanovocontrato());

                prospect.setObservacao(ProspectBody.getObservacao());


                return prospectRepository.save(prospect);
            } catch (NoSuchElementException e) {
                return "Não há saudação com id " + id;
            }
    }

    @Autowired
    private  ProspectRepository prospectRepository;

}
