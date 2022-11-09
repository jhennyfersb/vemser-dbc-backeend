package br.com.dbc.vemser.pessoaapi.dto;

import lombok.*;

@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ContatoDTO extends ContatoCreateDTO{
    private Integer idContato;
}
