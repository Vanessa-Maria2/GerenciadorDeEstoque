package com.example.gerenciadorDeEstoque.repository;

import com.example.gerenciadorDeEstoque.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
