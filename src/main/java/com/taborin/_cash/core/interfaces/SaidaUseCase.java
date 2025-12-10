package com.taborin._cash.core.interfaces;

import com.taborin._cash.core.domain.model.Saida;

import java.util.List;

public interface SaidaUseCase {
    void criar(Saida saida);
    void atualizarPorId(Saida saida, Long id);
    void deletarPorId(Long id);
    List<Saida> listarSaidas();
    Saida listarPorId(Long id);
}
