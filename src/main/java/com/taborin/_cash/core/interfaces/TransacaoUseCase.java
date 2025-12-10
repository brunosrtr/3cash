package com.taborin._cash.core.interfaces;

import com.taborin._cash.core.domain.model.Transacao;

import java.util.List;

public interface TransacaoUseCase {
    void criar(Transacao transacao);
    void atualizarPorId(Transacao transacao, Long id);
    void deletarPorId(Long id);
    List<Transacao> listarTransacoes();
    Transacao listarPorId(Long id);
    List<Transacao> listarPorUsuario(Long idUsuario);
}
