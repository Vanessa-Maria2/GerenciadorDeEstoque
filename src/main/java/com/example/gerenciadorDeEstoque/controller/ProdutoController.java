package com.example.gerenciadorDeEstoque.controller;

import com.example.gerenciadorDeEstoque.model.Produto;
import com.example.gerenciadorDeEstoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @RequestMapping("/produto")
    public List<Produto> listProdutos() {
        return (List<Produto>) produtoRepository.findAll();
    }
    @PostMapping("/produto")
    public Produto newProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
    @PutMapping("/produto/{id}")
    public Produto updateProduto(@RequestBody Produto produto, @PathVariable Long id) {
        return produtoRepository.findById(id).map(prod -> {
            prod.setNome(produto.getNome());
            prod.setPrecoVenda(produto.getPrecoVenda());
            prod.setPrecoCusto(produto.getPrecoCusto());
            prod.setQuantidade(produto.getQuantidade());
            return produtoRepository.save(prod);
        }).orElseGet(() -> {
            produto.setId(id);
            return produtoRepository.save(produto);
        });
    }

    @DeleteMapping("/produto/{id}")
    public void deleteProduto(@PathVariable Long id) {
        produtoRepository.delete(new Produto(id));
    }
}
