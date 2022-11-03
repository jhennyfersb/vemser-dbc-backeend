package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Endereco_Pessoa")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_ENDERECO_CONTATO")
    @SequenceGenerator(name = "SEQ_ENDERECO_CONTATO",sequenceName = "seq_endereco_contato",allocationSize = 1)
    @Column(name = "id_endereco")
    private Integer idEndereco;


    @JsonIgnore
    @ManyToMany(mappedBy = "enderecos")
    private Set<PessoaEntity> pessoas;

    @Column(name = "tipo")
    private TipoEndereco tipo;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "cep")
    private String cep;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "pais")
    private String pais;


}
