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

@ToString

@NoArgsConstructor

@Embeddable

public class ContatoEmpresaEntity {

    private String nome;

    private String sobrenome;

    private String telefone;

    
}

A anotação JPA @Embedded é usada para incorporar um tipo em outra entidade.

Especifica um campo ou propriedade persistente de uma entidade cujo valor é uma instância de uma classe incorporável.

A classe incorporável deve ser anotada como Embeddable.

@AllArgsConstructor

@Getter

@Setter

@ToString

@NoArgsConstructor

@Entity

public class EmpresaEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String nome;

    private String endereco;

    private String telefone;

    @Embedded
    private ContatoEmpresa contatoEmpresa;
  
}

Como resultado, temos nossa entidade Empresa , incorporando detalhes da classe ContatoEmpresaEntity e mapeando para uma única tabela de banco de dados.

O @Embedded foi usado para incorporar um tipo em outra entidade.