package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
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

/*
    @Schema(description = "Id da Pessoa :")
    private Integer idPessoa;
*/
    @Schema(description = "Tipo de contato : 1-Residencial 2-Comercial",example = "RESIDENCIAL")
    @NotNull
    private TipoContato tipoContato;

    @Schema(description = "Numero :(maximo  13 digitos)", example = "95991223456")
    @NotNull
    @Size(max = 13)
    private String numero;

    @Schema(description = "Descrição :",example = "whatsapp")
    @NotBlank
    @NotNull
    private String descricao;
}
