package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Contato")
public class ContatoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTATO")
    @SequenceGenerator(name = "SEQ_CONTATO", sequenceName = "seq_contato", allocationSize = 1)
    @Column(name = "id_contato")
    private Integer idContato;

    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name = "tipo")
    @Enumerated(EnumType.ORDINAL)
    private TipoContato tipoContato;

    @Column(name = "numero")
    private String numero;

    @Column(name = "descricao")
    private String descricao;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa",referencedColumnName = "id_pessoa",insertable = false,updatable = false)
    private PessoaEntity pessoa;

}
