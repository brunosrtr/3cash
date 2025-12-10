package com.taborin._cash.core.interfaces;

import com.taborin._cash.core.domain.model.Usuario;
import com.taborin._cash.infra.DTO.UsuarioDTO;

import java.util.List;

public interface UsuarioUseCase {
    void criar (UsuarioDTO usuario);
    void atualizarPorId (String nome, Long id);
    void deletarPorId (Long id);
    List<Usuario> listarUsuarios();
    Usuario listarporId (Long id);
}
