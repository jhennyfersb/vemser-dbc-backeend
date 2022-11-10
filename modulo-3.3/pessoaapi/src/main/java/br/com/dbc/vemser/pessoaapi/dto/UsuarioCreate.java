package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioCreate {
    @NotNull
    @Schema(description = "usuario",example = "jhennyfers")
    private String login;

    @NotNull
    @Schema(description = "senha",example = "2345@34")
    private String senha;
}
