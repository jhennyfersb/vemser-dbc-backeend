package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PessoaComContatoDTO extends PessoaCreateDTO{
    private Integer idPessoa;
    private List<ContatoDTO> contatos;
}
