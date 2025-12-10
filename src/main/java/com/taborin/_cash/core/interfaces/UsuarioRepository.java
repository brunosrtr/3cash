package com.taborin._cash.core.interfaces;

import com.taborin._cash.core.domain.model.Usuario;

import java.util.List;

public interface UsuarioRepository {
    void criar (Usuario usuario);
    void atualizarPorId (String nome, Long id);
    void deletarPorId (Long id);
    List<Usuario> listarUsuarios();
    Usuario listarporId (Long id);
}
