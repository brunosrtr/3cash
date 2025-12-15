package com.taborin._cash.core.domain.model;

import jakarta.persistence.Entity;

public class Professor extends Usuario {
    private Integer quantiaMoletom;

    public Integer getQuantiaMoletom() {
        return quantiaMoletom;
    }

    public void setQuantiaMoletom(Integer quantiaMoletom) {
        this.quantiaMoletom = quantiaMoletom;
    }
}
