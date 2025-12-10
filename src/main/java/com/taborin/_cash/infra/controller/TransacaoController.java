package com.taborin._cash.infra.controller;

import com.taborin._cash.core.domain.model.Transacao;
import com.taborin._cash.core.interfaces.TransacaoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoUseCase transacaoUseCase;

    @PostMapping
    public void criar(@RequestBody Transacao transacao) {
        transacaoUseCase.criar(transacao);
    }

    @PutMapping("/{id}")
    public void atualizarPorId(@RequestBody Transacao transacao, @PathVariable Long id) {
        transacaoUseCase.atualizarPorId(transacao, id);
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        transacaoUseCase.deletarPorId(id);
    }

    @GetMapping
    public List<Transacao> listarTransacoes() {
        return transacaoUseCase.listarTransacoes();
    }

    @GetMapping("/{id}")
    public Transacao listarPorId(@PathVariable Long id) {
        return transacaoUseCase.listarPorId(id);
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Transacao> listarPorUsuario(@PathVariable Long idUsuario) {
        return transacaoUseCase.listarPorUsuario(idUsuario);
    }
}