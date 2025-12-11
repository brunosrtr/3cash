package com.taborin._cash.core.domain.usecase;

import com.taborin._cash.core.domain.model.Evento;
import com.taborin._cash.core.interfaces.EventoRepository;
import com.taborin._cash.core.interfaces.EventoUseCase;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

public class EventoUseCaseImpl implements EventoUseCase {

    @Autowired
    EventoRepository eventoRepository;

    @Override
    public void criar(Evento evento) {
        if (evento.getData() == null) {
            evento.setData(LocalDate.now());
        }
        eventoRepository.criar(evento);
    }

    @Override
    public void atualizarPorId(Evento evento, Long id) {
        eventoRepository.atualizarPorId(evento, id);
    }

    @Override
    public void deletarPorId(Long id) {
        eventoRepository.deletarPorId(id);
    }

    @Override
    public List<Evento> listarEventos() {
        return eventoRepository.listarEventos();
    }

    @Override
    public Evento listarPorId(Long id) {
        return eventoRepository.listarPorId(id);
    }
}
