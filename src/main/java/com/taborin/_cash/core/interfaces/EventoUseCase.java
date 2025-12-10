package com.taborin._cash.core.interfaces;


import com.taborin._cash.core.domain.model.Evento;

import java.util.List;

public interface EventoUseCase {
    void criar(Evento evento);
    void atualizarPorId(Evento evento, Long id);
    void deletarPorId(Long id);
    List<Evento> listarEventos();
    Evento listarPorId(Long id);
}
