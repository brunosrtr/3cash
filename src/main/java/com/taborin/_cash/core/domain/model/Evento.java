package com.taborin._cash.core.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "evento")
public class Evento {

    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor_arrecadado")
    private Integer valorArrecadado;

    @Column(name="data")
    private LocalDate data;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValorArrecadado() {
        return valorArrecadado;
    }

    public void setValorArrecadado(Integer valorArrecadado) {
        this.valorArrecadado = valorArrecadado;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
}
