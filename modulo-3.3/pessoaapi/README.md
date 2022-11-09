Pessoa API

javax.persistence.Embeddable - anotação JPA

javax.persistence.EmbeddedId - anotação JPA

Representamos uma chave primária composta no Spring Data usando a anotação @Embeddable em uma classe.

A classe incorporável deve ser anotada como Embeddable.

EmbeddedId para inserir uma chave composta em uma entidade.

No Exemplo a classe PessoaFilmeId recebe a anotação @Embeddable para representar a chave primaria composta de PessoaFilmeEntity

@AllArgsConstructor

@Getter

@Setter

@ToString

@NoArgsConstructor

@Embeddable

public class PessoaFilmeId implements Serializable {

    @Column(name = "id_filme")
    private Integer idFilme;

    @Column(name = "id_pessoa")
    private Integer idPessoa;

}
Para inserir  uma chave composta em uma entidade devemos utilizar a anotação @EmbeddedId

então adiciona @EmbeddedId em PessoaFilmeEntity em um campo do tipo @Embeddable

@AllArgsConstructor

@NoArgsConstructor

@Getter

@Setter

@ToString

@Entity

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

Essa chave de id_filme e id_pessoa é então incorporada na classe de entidade PessoaFilmeEntity correspondente  como a chave primária composta 

usando a anotação @EmbeddedId em um campo do tipo @Embeddable que seria o pessoaFilmeId .


javax.persistence.Embedded - anotação JPA

A JPA fornece a anotação @Embeddable  para declarar que uma classe será incorporada por outras entidades.



@AllArgsConstructor

@Getter

@Setter

@NoArgsConstructor

@Embeddable

public class SexoEntity {

    private String sexo;

}

A anotação JPA @Embedded é usada para incorporar um tipo em outra entidade.

Especifica um campo ou propriedade persistente de uma entidade cujo valor é uma instância de uma classe incorporável.

A classe incorporável deve ser anotada como Embeddable.


@AllArgsConstructor

@Getter

@Setter

@Entity(name = "Pessoa")

public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOA2")
    @SequenceGenerator(name = "SEQ_PESSOA2", sequenceName = "seq_pessoa2", allocationSize = 1)
    @Column(name = "id_pessoa")
    private Integer idPessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Embedded
    private SexoEntity sexo;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "pessoa",cascade = CascadeType.ALL,orphanRemoval = true)
    private PetEntity pet;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "pessoa",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ContatoEntity> contatos;


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Pessoa_X_Pessoa_Endereco",
    joinColumns = @JoinColumn(name = "id_pessoa"),
    inverseJoinColumns = @JoinColumn(name = "id_endereco"))
    private Set<EnderecoEntity> enderecos;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true )
    @JoinColumn(name = "ID_PESSOA",referencedColumnName = "ID_PESSOA")
    private Set<PessoaFilmeEntity> pessoaXFilmes;


    public PessoaEntity() {
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
Como resultado, temos nossa entidade PessoaEntity , incorporando detalhes da classe SexoEntity e mapeando para uma única tabela de banco de dados.

O @Embedded foi usado para incorporar um tipo em outra entidade.