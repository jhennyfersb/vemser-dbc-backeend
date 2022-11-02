package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

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

    private String numero;

    private String descricao;

}
