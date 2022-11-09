package br.com.dbc.vemser.pessoaapi.dto;

import lombok.*;

@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class FilmeDTO extends FilmeCreateDTO {
    private Integer idFilme;
}
