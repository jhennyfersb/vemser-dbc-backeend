package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCompletaDTO;
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
    List<PessoaEntity> recuperarPessoasQueTemEnderecos(@Param("nome") String nome);

    @Query("select new br.com.dbc.vemser.pessoaapi.dto.PessoaCompletaDTO(" +
            "       P.idPessoa,\n" +
            "       P.nome,\n" +
            "       P.email,\n" +
            "       c.numero,\n" +
            "       e.cep,\n" +
            "       e.cidade,\n" +
            "       e.estado,\n" +
            "       e.pais,\n" +
            "       pt.nome ,\n" +
            "       pf.filmeEntity.descricao,\n" +
            "       pf.descricao ,\n" +
            "       pf.dateAssistido ,\n" +
            "       pf.nota ,\n" +
            "       pf.filmeEntity.nota) " +
            "from Pessoa P\n" +
            "         left join P.contatos c " +
            "         left join  P.enderecos e " +
            "         left join P.pet pt" +
            "         left join P.pessoaXFilmes pf" +
            "        where(:idPessoa is null or P.idPessoa = :idPessoa)")
    List<PessoaCompletaDTO> findAllPessoa(Integer idPessoa);

}