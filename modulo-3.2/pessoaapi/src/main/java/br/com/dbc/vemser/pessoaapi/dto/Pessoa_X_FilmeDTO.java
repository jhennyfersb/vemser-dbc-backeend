package br.com.dbc.vemser.pessoaapi.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;


@ToString
@Getter
@Setter
@NoArgsConstructor
public class Pessoa_X_FilmeDTO extends Pessoa_X_FilmeCreateDTO{
  private Integer idPessoa;

  public Pessoa_X_FilmeDTO(Integer idFilme,Integer idPessoa, LocalDate dateAssistido, String descricao, Integer nota) {
    super(idFilme, dateAssistido, descricao, nota);
    this.idPessoa = idPessoa;
  }
}
