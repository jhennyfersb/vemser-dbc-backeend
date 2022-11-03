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
public class PessoaComFilmesDTO extends PessoaCreateDTO{
    private Integer idPessoa;
    private List<Pessoa_X_FilmeDTO> listPessoa_x_filmeDTO;
}
