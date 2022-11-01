package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCreateDTO {

    @NotBlank
    @NotEmpty
    @Schema(description = "Nome da Pessoa",example = "Jhennyfer")
    private String nome;

    @NotNull
    @Schema(description = "data de nascimento",example = "06/12/1995")
    private LocalDate dataNascimento;

    @Schema(description = "email",example = "jhennyffersobrinho@gmail.com")
    private String email;

    @Schema(description = "cpf ",example = "05687265104")
    @NotNull(message = "cpf invalido")
    @Size(min = 11, max = 11)
    private String cpf;
}
