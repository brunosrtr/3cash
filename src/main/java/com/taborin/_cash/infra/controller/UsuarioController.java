package com.taborin._cash.infra.controller;

import com.taborin._cash.core.domain.model.Usuario;
import com.taborin._cash.core.interfaces.UsuarioUseCase;
import com.taborin._cash.infra.DTO.AlunoDTO;
import com.taborin._cash.infra.DTO.ProfessorDTO;
import com.taborin._cash.infra.DTO.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @PostMapping("/professor")
    public void criar(@RequestBody ProfessorDTO dto) {
        usuarioUseCase.criar(dto);
    }

    @PostMapping("/aluno")
    public void criar(@RequestBody AlunoDTO dto) {
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

