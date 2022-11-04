package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    @Query("  select p" +
            "   from Pessoa p " +
            "   join p.enderecos e")
    List<PessoaEntity> recuperarPessoasQueTemEnderecos(@Param("nome")String nome);
}