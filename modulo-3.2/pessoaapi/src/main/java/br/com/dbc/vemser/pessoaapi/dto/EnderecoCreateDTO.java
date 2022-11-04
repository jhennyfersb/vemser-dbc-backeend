package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class EnderecoCreateDTO {

    @Schema(description = "Id da Pessoa :")
    private Integer idPessoa;

    @Schema(description = "Tipo de Endereco : 1-Residencial 2-Comercial", example = "RESIDENCIAL")
    @NotNull
    private TipoEndereco tipo;

    @Schema(description = "Logradouro : (maximo 250 caracteres", example = "Av Brasil")
    @NotBlank
    @Size(max = 250)
    private String logradouro;

    @Schema(description = "Numero :", example = "345")
    @NotNull
    private Integer numero;

    @Schema(description = "Complemento :", example = "perto de")
    private String complemento;

    @Schema(description = "Cep : (maximo 8 digitos", example = "85501057")
    @NotBlank
    @Size(max = 8)
    private String cep;

    @Schema(description = "Cidade : (maximo 250 caracteres", example = "Pato Branco")
    @NotBlank
    @Size(max = 250)
    private String cidade;

    @Schema(description = "Estado :", example = "Parana")
    @NotBlank
    @NotNull
    private String estado;

    @Schema(description = "Pais :", example = "Brasil")
    @NotBlank
    @NotNull
    private String pais;
}
