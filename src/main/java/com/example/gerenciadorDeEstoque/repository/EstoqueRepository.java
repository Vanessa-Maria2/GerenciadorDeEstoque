package com.example.gerenciadorDeEstoque.repository;

import com.example.gerenciadorDeEstoque.model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

}
