package com.example.gerenciadorDeEstoque.repository;

import com.example.gerenciadorDeEstoque.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

}
