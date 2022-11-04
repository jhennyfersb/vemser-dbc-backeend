package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.Table;
import java.time.LocalDate;

@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PessoaFilmeCreateDTO {
    @Schema(description = "id do filme")
    private Integer idFilme;

    @Schema(description = "Data do filme assistido :")
    private LocalDate dateAssistido;

    @Schema(description = "Descrição :")
    private String descricao;

    @Schema(description = "Nota :")
    private Integer nota;
}
