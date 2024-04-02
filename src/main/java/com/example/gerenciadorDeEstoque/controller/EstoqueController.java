package com.example.gerenciadorDeEstoque.controller;

import com.example.gerenciadorDeEstoque.model.Estoque;
import com.example.gerenciadorDeEstoque.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @RequestMapping("/estoque")
    public List<Estoque> listEstoques() {
        return (List<Estoque>) estoqueRepository.findAll();
    }
    @PostMapping("/estoque")
    public Estoque newEstoque(@RequestBody Estoque estoque) {
        return estoqueRepository.save(estoque);
    }
    @PutMapping("/estoque/{id}")
    public Estoque updateEstoque(@RequestBody Estoque estoque, @PathVariable Long id) {
        return estoqueRepository.findById(id).map(estoque2 -> {
            estoque2.setLoja(estoque.getLoja());
            estoque2.setProdutos(estoque.getProdutos());
            return estoqueRepository.save(estoque2);
        }).orElseGet(() -> {
            estoque.setId(id);
            return estoqueRepository.save(estoque);
        });
    }

    @DeleteMapping("/estoque/{id}")
    public void deleteEstoque(@PathVariable Long id) {
        estoqueRepository.delete(new Estoque(id));
    }
}