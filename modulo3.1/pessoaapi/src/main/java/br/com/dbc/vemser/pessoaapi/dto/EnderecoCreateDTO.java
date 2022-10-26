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

    @Schema(description = "Tipo de Endereco : 1-Residencial 2-Comercial")
    @NotNull
    private TipoEndereco tipo;

    @Schema(description = "Logradouro : (maximo 250 caracteres")
    @NotBlank
    @Size(max = 250)
    private String logradouro;

    @Schema(description = "Numero :")
    @NotNull
    private Integer numero;

    @Schema(description = "Complemento :")
    private String complemento;

    @Schema(description = "Cep : (maximo 8 digitos")
    @NotBlank
    @Size(max = 8)
    private String cep;

    @Schema(description = "Cidade : (maximo 250 caracteres")
    @NotBlank
    @Size(max = 250)
    private String cidade;

    @Schema(description = "Estado :")
    @NotBlank
    @NotNull
    private String estado;

    @Schema(description = "Pais :")
    @NotBlank
    @NotNull
    private String pais;
}
