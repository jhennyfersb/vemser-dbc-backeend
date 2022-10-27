package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Getter;

@Getter
public enum Sexo {
    F("FEMININO"),M("MASCULINO");
    private String sexo;
    Sexo(String sexo) {
        this.sexo = sexo;
    }
}
