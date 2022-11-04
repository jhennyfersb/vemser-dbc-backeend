package br.com.dbc.vemser.pessoaapi.entity;

import br.com.dbc.vemser.pessoaapi.entity.pk.PessoaFilmeId;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "PESSOA_X_FILME")
public class PessoaFilmeEntity implements Serializable {

    @EmbeddedId
    private PessoaFilmeId pessoaFilmeId;

    @Column(name = "dt_assistido")
    private LocalDate dateAssistido;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nota_pessoa")
    private Integer nota;

}
