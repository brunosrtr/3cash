package com.taborin._cash.infra.controller;

import com.taborin._cash.core.domain.model.Usuario;
import com.taborin._cash.core.interfaces.UsuarioUseCase;
import com.taborin._cash.infra.DTO.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @PostMapping
    public void criar(@RequestBody UsuarioDTO dto) {
        usuarioUseCase.criar(dto);
    }

    @PutMapping("/{id}")
    public void atualizarPorId(@RequestBody UsuarioDTO dto, @PathVariable Long id) {
        usuarioUseCase.atualizarPorId(dto.getNome(), id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        usuarioUseCase.deletarPorId(id);
    }

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioUseCase.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario listarporId(@PathVariable Long id) {
        return usuarioUseCase.listarporId(id);
    }
}

