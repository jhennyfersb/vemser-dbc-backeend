package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@AllArgsConstructor
@Getter
@Setter
@Entity(name = "Filme")
public class FilmeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "seq_filme", allocationSize = 1)
    @Column(name = "id_filme")
    private Integer idFilme;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "nota")
    private Integer nota;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "tipo")
    private TipoFilme tipoFilme;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, mappedBy = "filmeEntity")
    //@JoinColumn(name = "ID_FILME", referencedColumnName = "ID_FILME")
    private Set<PessoaFilmeEntity> pessoaXFilmes;

    public FilmeEntity() {
    }

    @Override
    public String toString() {
        return "FilmeEntity{" +
                "idFilme=" + idFilme +
                ", descricao='" + descricao + '\'' +
                ", nota=" + nota +
                ", tipoFilme=" + tipoFilme +
                '}';
    }
}
