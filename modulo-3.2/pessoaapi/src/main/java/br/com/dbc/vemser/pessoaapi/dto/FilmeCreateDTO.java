package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoFilme;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class FilmeCreateDTO {

    @NotEmpty
    @NotNull
    @Schema(description = "descrição :")
    private String descricao;

    @NotNull
    @Schema(description = "Nota :")
    private Integer nota;

    @NotNull
    @Schema(description = "Tipo de Filme:")
    private TipoFilme tipoFilme;

}
