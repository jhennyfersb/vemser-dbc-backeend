package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class ContatoCreateDTO {
    private Integer idContato;
    private Integer idPessoa;
    @NotNull
    private TipoContato tipoContato;
    @NotNull
    @Size(max = 13)
    private String numero;
    @NotBlank
    @NotNull
    private String descricao;
}
