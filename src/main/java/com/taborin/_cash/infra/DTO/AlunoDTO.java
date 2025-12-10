package com.taborin._cash.infra.DTO;

public class AlunoDTO extends UsuarioDTO {
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
