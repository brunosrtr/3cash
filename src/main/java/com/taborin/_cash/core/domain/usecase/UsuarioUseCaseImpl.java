package com.taborin._cash.core.domain.usecase;

import com.taborin._cash.core.domain.model.Aluno;
import com.taborin._cash.core.domain.model.Professor;
import com.taborin._cash.core.domain.model.Usuario;
import com.taborin._cash.core.interfaces.UsuarioRepository;
import com.taborin._cash.core.interfaces.UsuarioUseCase;
import com.taborin._cash.infra.DTO.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void criar(UsuarioDTO dto) {

        Usuario usuario;

        if(dto.getTipo().equalsIgnoreCase("aluno")){
            usuario = new Aluno();
        } else if(dto.getTipo().equalsIgnoreCase("professor")){
            usuario = new Professor();
        } else {
            throw new IllegalArgumentException("Tipo inválido");
        }

        usuario.setNome(dto.getNome());

        usuarioRepository.criar(usuario);
    }


    @Override
    public void atualizarPorId(String nome, Long id) {
        usuarioRepository.atualizarPorId(nome, id);
    }

    @Override
    public void deletarPorId(Long id) {
        usuarioRepository.deletarPorId(id);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }

    @Override
    public Usuario listarporId(Long id) {
        return usuarioRepository.listarporId(id);
    }
}
