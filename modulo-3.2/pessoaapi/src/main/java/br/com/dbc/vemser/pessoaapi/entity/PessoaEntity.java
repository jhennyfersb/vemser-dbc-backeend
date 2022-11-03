package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

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