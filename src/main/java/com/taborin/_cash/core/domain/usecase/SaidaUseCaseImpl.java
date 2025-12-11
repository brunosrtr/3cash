package com.taborin._cash.core.domain.usecase;

import com.taborin._cash.core.domain.model.Saida;
import com.taborin._cash.core.interfaces.SaidaRepository;
import com.taborin._cash.core.interfaces.SaidaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaidaUseCaseImpl implements SaidaUseCase {

    @Autowired
    SaidaRepository saidaRepository;

    @Override
    public void criar(Saida saida) {
        if (saida.getData() == null) {
            saida.setData(LocalDate.now());
        }
        saidaRepository.criar(saida);
    }

    @Override
    public void atualizarPorId(Saida saida, Long id) {
        saidaRepository.atualizarPorId(saida, id);
    }

    @Override
    public void deletarPorId(Long id) {
        saidaRepository.deletarPorId(id);
    }

    @Override
    public List<Saida> listarSaidas() {
        return saidaRepository.listarSaidas();
    }

    @Override
    public Saida listarPorId(Long id) {
        return saidaRepository.listarPorId(id);
    }
}
