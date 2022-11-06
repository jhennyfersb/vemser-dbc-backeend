package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.entity.pk.PessoaFilmeId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PESSOA_X_FILME")
public class PessoaFilmeEntity {

    @EmbeddedId
    private PessoaFilmeId pessoaFilmeId;

    @Column(name = "dt_assistido")
    private LocalDate dateAssistido;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nota_pessoa")
    private Integer nota;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idFilme")
    @JoinColumn(name = "id_filme")
    private FilmeEntity filmeEntity;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idPessoa")
    @JoinColumn(name = "id_pessoa")
    private PessoaEntity pessoaEntity;


}
