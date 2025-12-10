package com.taborin._cash.core.domain.usecase;

import com.taborin._cash.core.domain.model.Transacao;
import com.taborin._cash.core.interfaces.TransacaoRepository;
import com.taborin._cash.core.interfaces.TransacaoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransacaoUseCaseImpl implements TransacaoUseCase {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Override
    public void criar(Transacao transacao) {
        if (transacao.getData() == null) {
            transacao.setData(LocalDate.now());
        }
        transacaoRepository.criar(transacao);
    }

    @Override
    public void atualizarPorId(Transacao transacao, Long id) {
        transacaoRepository.atualizarPorId(transacao, id);
    }

    @Override
    public void deletarPorId(Long id) {
        transacaoRepository.deletarPorId(id);
    }

    @Override
    public List<Transacao> listarTransacoes() {
        return transacaoRepository.listarTransacoes();
    }

    @Override
    public Transacao listarPorId(Long id) {
        return transacaoRepository.listarPorId(id);
    }

    @Override
    public List<Transacao> listarPorUsuario(Long idUsuario) {
        return transacaoRepository.listarPorUsuario(idUsuario);
    }
}
