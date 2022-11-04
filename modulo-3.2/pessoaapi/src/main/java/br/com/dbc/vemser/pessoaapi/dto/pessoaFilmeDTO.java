package br.com.dbc.vemser.pessoaapi.dto;

import lombok.*;

import java.time.LocalDate;


@ToString
@Getter
@Setter
@NoArgsConstructor
public class pessoaFilmeDTO extends PessoaFilmeCreateDTO {
  private Integer idPessoa;

  public pessoaFilmeDTO(Integer idFilme, Integer idPessoa, LocalDate dateAssistido, String descricao, Integer nota) {
    super(idFilme, dateAssistido, descricao, nota);
    this.idPessoa = idPessoa;
  }
}
