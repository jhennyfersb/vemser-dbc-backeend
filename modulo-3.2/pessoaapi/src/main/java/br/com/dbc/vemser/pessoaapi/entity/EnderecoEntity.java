package br.com.dbc.vemser.pessoaapi.entity;

import lombok.*;

import javax.persistence.*;

@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Endereco")
public class EnderecoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQ_ENDERECO")
    @SequenceGenerator(name = "SEQ_ENDERECO",sequenceName = "seq_endereco",allocationSize = 1)
    @Column(name = "id_endereco")
    private Integer idEndereco;

    //private Integer idPessoa;

    private TipoEndereco tipo;

    private String logradouro;

    private Integer numero;
    private String complemento;

    private String cep;

    private String cidade;

    private String estado;

    private String pais;


}
