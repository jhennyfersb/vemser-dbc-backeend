package br.com.dbc.vemser.pessoaapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PessoaComFilmeAssistidoDTO extends PessoaCreateDTO {
    private Integer idPessoa;
    private List<pessoaFilmeDTO> pessoaFilmes;

    public PessoaComFilmeAssistidoDTO(String nome,
                                      LocalDate dataNascimento,
                                      String email,
                                      String cpf,
                                      Integer idPessoa,
                                      List<pessoaFilmeDTO> pessoaFilmes) {
        super(nome, dataNascimento, email, cpf);
        this.idPessoa = idPessoa;
        this.pessoaFilmes = pessoaFilmes;
    }
}
