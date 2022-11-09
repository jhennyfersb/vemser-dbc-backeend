package br.com.dbc.vemser.pessoaapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
@ToString
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Pet")
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "PET_SEQ")
    @SequenceGenerator(name = "PET_SEQ",sequenceName = "seq_pet",allocationSize = 1)
    @Column(name = "id_pet")
    private Integer idPet;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pessoa",referencedColumnName = "id_pessoa")
    private PessoaEntity pessoa;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private TipoPet tipoPet;

}
