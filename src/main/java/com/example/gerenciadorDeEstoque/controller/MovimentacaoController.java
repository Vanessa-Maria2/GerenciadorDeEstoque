package com.example.gerenciadorDeEstoque.controller;

import com.example.gerenciadorDeEstoque.model.Movimentacao;
import com.example.gerenciadorDeEstoque.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovimentacaoController {

    @Autowired
    private MovimentacaoRepository movimentacaoRepository;

    @RequestMapping("/movimentacao")
    public List<Movimentacao> listMovimentacoes() {
        return (List<Movimentacao>) movimentacaoRepository.findAll();
    }
    @PostMapping("/movimentacao")
    public Movimentacao newMovimentacao(@RequestBody Movimentacao movimentacao) {
        return movimentacaoRepository.save(movimentacao);
    }
    @PutMapping("/movimentacao/{id}")
    public Movimentacao updateMovimentacao(@RequestBody Movimentacao movimentacao, @PathVariable Long id) {
        return movimentacaoRepository.findById(id).map(movimentacao2 -> {
            movimentacao2.setData(movimentacao.getData());
            movimentacao2.setTipoMovimentacao(movimentacao.getTipoMovimentacao());
            movimentacao2.setUsuario(movimentacao.getUsuario());
            movimentacao2.setProdutos(movimentacao.getProdutos());
            movimentacao2.setQuantidade(movimentacao.getQuantidade());
            return movimentacaoRepository.save(movimentacao2);
        }).orElseGet(() -> {
            movimentacao.setId(id);
            return movimentacaoRepository.save(movimentacao);
        });
    }

    @DeleteMapping("/movimentacao/{id}")
    public void deleteMovimentacao(@PathVariable Long id) {
        movimentacaoRepository.delete(new Movimentacao(id));
    }
}
