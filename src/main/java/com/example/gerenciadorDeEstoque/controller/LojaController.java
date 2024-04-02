package com.example.gerenciadorDeEstoque.controller;

import com.example.gerenciadorDeEstoque.model.Loja;
import com.example.gerenciadorDeEstoque.repository.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LojaController {

    @Autowired
    private LojaRepository lojaRepository;

    @RequestMapping("/loja")
    public List<Loja> listLojas() {
        return (List<Loja>) lojaRepository.findAll();
    }
    @PostMapping("/loja")
    public Loja newLoja(@RequestBody Loja loja) {
        return lojaRepository.save(loja);
    }
    @PutMapping("/loja/{id}")
    public Loja updateLoja(@RequestBody Loja loja, @PathVariable Long id) {
        return lojaRepository.findById(id).map(loja2 -> {
            loja2.setNome(loja.getNome());
            loja2.setLocalizacao(loja.getLocalizacao());
            loja2.setProdutos(loja.getProdutos());
            return lojaRepository.save(loja2);
        }).orElseGet(() -> {
            loja.setId(id);
            return lojaRepository.save(loja);
        });
    }

    @DeleteMapping("/loja/{id}")
    public void deleteLoja(@PathVariable Long id) {
        lojaRepository.delete(new Loja(id));
    }
}
