package br.com.dbc.vemser.pessoaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class SexoEntity {
    private String sexo;
}
