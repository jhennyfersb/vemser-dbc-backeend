package br.com.dbc.vemser.pessoaapi.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PessoaCompletaDTO {
    private Integer id;
    private String nomePessoa;
    private String email;
    private String numero;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private String nomePet;
    private String descricaoFilme;
    private String descricaoPessoa;
    private LocalDate dateAssistido;
    private Integer notaPessoa;
    private Integer notaFilme;


}
