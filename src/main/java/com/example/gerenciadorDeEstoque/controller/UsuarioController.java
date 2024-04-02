package com.example.gerenciadorDeEstoque.controller;


import com.example.gerenciadorDeEstoque.model.Usuario;
import com.example.gerenciadorDeEstoque.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @RequestMapping("/usuario")
    public List<Usuario> listUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }
    @PostMapping("/usuario")
    public Usuario newUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
    @PutMapping("/usuario/{id}")
    public Usuario updateUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
        return usuarioRepository.findById(id).map(usuario2 -> {
            usuario2.setNome(usuario.getNome());
            usuario2.setEmail(usuario.getEmail());
            return usuarioRepository.save(usuario2);
        }).orElseGet(() -> {
            usuario.setId(id);
            return usuarioRepository.save(usuario);
        });
    }

    @DeleteMapping("/usuario/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioRepository.delete(new Usuario(id));
    }
}
