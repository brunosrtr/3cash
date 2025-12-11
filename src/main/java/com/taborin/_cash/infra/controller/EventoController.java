package com.taborin._cash.infra.controller;

import com.taborin._cash.core.domain.model.Evento;
import com.taborin._cash.core.interfaces.EventoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoUseCase eventoUseCase;

    @PostMapping
    public void criar(@RequestBody Evento evento) {
        eventoUseCase.criar(evento);
    }

    @PutMapping("/{id}")
    public void atualizarPorId(@RequestBody Evento evento, @PathVariable Long id) {
        eventoUseCase.atualizarPorId(evento, id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        eventoUseCase.deletarPorId(id);
    }

    @GetMapping
    public List<Evento> listarEventos() {
        return eventoUseCase.listarEventos();
    }

    @GetMapping("/{id}")
    public Evento listarPorId(@PathVariable Long id) {
        return eventoUseCase.listarPorId(id);
    }
}