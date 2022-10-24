package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaCreateDTO {
    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull(message = "cpf invalido")
    @Size(min = 11, max = 11)
    private String cpf;
}
