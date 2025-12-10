package com.taborin._cash.infra.controller;

import com.taborin._cash.core.domain.model.Saida;
import com.taborin._cash.core.interfaces.SaidaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/saida")
public class SaidaController {

    @Autowired
    private SaidaUseCase saidaUseCase;

    @PostMapping
    public void criar(@RequestBody Saida saida) {
        saidaUseCase.criar(saida);
    }

    @PutMapping("/{id}")
    public void atualizarPorId(@RequestBody Saida saida, @PathVariable Long id) {
        saidaUseCase.atualizarPorId(saida, id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        saidaUseCase.deletarPorId(id);
    }

    @GetMapping
    public List<Saida> listarSaidas() {
        return saidaUseCase.listarSaidas();
    }

    @GetMapping("/{id}")
    public Saida listarPorId(@PathVariable Long id) {
        return saidaUseCase.listarPorId(id);
    }
}