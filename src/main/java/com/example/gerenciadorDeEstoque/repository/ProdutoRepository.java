package com.example.gerenciadorDeEstoque.repository;

import com.example.gerenciadorDeEstoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
