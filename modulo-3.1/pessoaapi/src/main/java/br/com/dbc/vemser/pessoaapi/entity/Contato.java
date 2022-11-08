package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Contato {

    private Integer idContato;

    private Integer idPessoa;

    private TipoContato tipoContato;

    private String numero;

    private String descricao;

}
