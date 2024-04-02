package com.example.gerenciadorDeEstoque.controller;

import com.example.gerenciadorDeEstoque.model.Acesso;
import com.example.gerenciadorDeEstoque.repository.AcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AcessoController {

    @Autowired
    private AcessoRepository acessoRepository;

    @RequestMapping("/acesso")
    public List<Acesso> listAcessos() {
        return (List<Acesso>) acessoRepository.findAll();
    }
    @PostMapping("/acesso")
    public Acesso newAcesso(@RequestBody Acesso acesso) {
        return acessoRepository.save(acesso);
    }
    @PutMapping("/acesso/{id}")
    public Acesso updateAcesso(@RequestBody Acesso acesso, @PathVariable Long id) {
        return acessoRepository.findById(id).map(acesso2 -> {
            acesso2.setData(acesso.getData());
            acesso2.setHorarioEntrada(acesso.getHorarioEntrada());
            acesso2.setHorarioSaida(acesso.getHorarioSaida());
            acesso2.setUsuario(acesso.getUsuario());
            return acessoRepository.save(acesso2);
        }).orElseGet(() -> {
            acesso.setId(id);
            return acessoRepository.save(acesso);
        });
    }

    @DeleteMapping("/acesso/{id}")
    public void deleteAcesso(@PathVariable Long id) {
        acessoRepository.delete(new Acesso(id));
    }
}
