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
public class PessoaDTO extends PessoaCreateDTO{
    private Integer idPessoa;
    private List<EnderecoDTO> enderecos;
    private List<ContatoDTO> contatos;
    private List<pessoaFilmeDTO> listPessoa_x_filmeDTO;
}
