package com.talitanunes.FluxoDeCaixa.Models;

import lombok.Getter;

@Getter
public enum TypeErrorAPI {

    VALIDATION_ERROR("VALIDATION", "Erro de validação."),
    UNEXPECTED_ERROR("ERROR", "Erro não mapeado. Houve um erro interno do servidor ");


    private String cod;
    private String desc;

    TypeErrorAPI(String cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }
}
