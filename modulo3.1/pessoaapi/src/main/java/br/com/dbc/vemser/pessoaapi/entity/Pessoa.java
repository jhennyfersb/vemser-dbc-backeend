package br.com.dbc.vemser.pessoaapi.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Pessoa {
    private Integer idPessoa;

    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull(message = "cpf invalido")
    @Size(min = 11, max = 11)
    private String cpf;

    public Pessoa() {
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
