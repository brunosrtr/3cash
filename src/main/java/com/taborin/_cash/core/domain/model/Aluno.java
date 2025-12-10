package com.taborin._cash.core.domain.model;

public class Aluno extends Usuario {
    private Integer quantiaMensalidade;
    private Integer quantiaMoletom;

    public Integer getQuantiaMensalidade() {
        return quantiaMensalidade;
    }

    public void setQuantiaMensalidade(Integer quantiaMensalidade) {
        this.quantiaMensalidade = quantiaMensalidade;
    }

    public Integer getQuantiaMoletom() {
        return quantiaMoletom;
    }

    public void setQuantiaMoletom(Integer quantiaMoletom) {
        this.quantiaMoletom = quantiaMoletom;
    }
}
