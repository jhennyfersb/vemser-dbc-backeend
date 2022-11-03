package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.entity.FilmeEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.entity.fk.PessoaFilmeId;
import br.com.dbc.vemser.pessoaapi.entity.PessoaFilmeEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.FilmeRepository;
import br.com.dbc.vemser.pessoaapi.repository.Pessoa_X_FilmeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FilmeService {
    private final PessoaService pessoaService;

    private final FilmeRepository filmeRepository;
    private final Pessoa_X_FilmeRepository pessoa_x_filmeRepository;

    private final ObjectMapper objectMapper;

    public List<FilmeDTO> list() {
        return filmeRepository.findAll()
                .stream()
                .map(filmeEntity -> objectMapper.convertValue(filmeEntity, FilmeDTO.class))
                .collect(Collectors.toList());
    }
    public List<FilmeDTO> listByFilme(Integer id) throws RegraDeNegocioException {

        return Collections.singletonList(objectMapper.convertValue(findByIdFilme(id), FilmeDTO.class));
    }

    private FilmeEntity findByIdFilme(Integer id) throws RegraDeNegocioException {
        return filmeRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Filme não encontrado"));
    }

    public FilmeDTO create(FilmeCreateDTO filme) {

        FilmeEntity filmeEntity = objectMapper.convertValue(filme, FilmeEntity.class);
        FilmeEntity filmeEntity1 = filmeRepository.save(filmeEntity);

        return objectMapper.convertValue(filmeEntity1, FilmeDTO.class);
    }

    public FilmeDTO update(Integer id,FilmeCreateDTO filmeAtualizar)throws RegraDeNegocioException{
        FilmeEntity filmeEntityRecuperado = findByIdFilme(id);

        filmeEntityRecuperado.setDescricao(filmeAtualizar.getDescricao());
        filmeEntityRecuperado.setTipoFilme(filmeAtualizar.getTipoFilme());
        filmeEntityRecuperado.setNota(filmeAtualizar.getNota());

        filmeRepository.save(filmeEntityRecuperado);

        return objectMapper.convertValue(filmeEntityRecuperado, FilmeDTO.class);
    }
    public void delete(Integer id) throws RegraDeNegocioException {
        FilmeEntity filmeEntity1deletado = findByIdFilme(id);
        pessoa_x_filmeRepository.deleteAll(filmeEntity1deletado.getPessoaXFilmes());
        filmeRepository.delete(filmeEntity1deletado);
    }

    public Pessoa_X_FilmeDTO avaliarFilme(Integer idPessoa,Pessoa_X_FilmeCreateDTO pessoa_x_filmeCreateDTO) throws RegraDeNegocioException {
       PessoaEntity pessoa = pessoaService.findByIdPessoa(idPessoa);
       FilmeEntity filme = findByIdFilme(pessoa_x_filmeCreateDTO.getIdFilme());

        PessoaFilmeEntity pessoa__filme1 = new PessoaFilmeEntity(new PessoaFilmeId(filme.getIdFilme(), pessoa.getIdPessoa()),
                pessoa_x_filmeCreateDTO.getDateAssistido(),
                pessoa_x_filmeCreateDTO.getDescricao(),
                pessoa_x_filmeCreateDTO.getNota());
        PessoaFilmeEntity pessoa__filmeCriado = pessoa_x_filmeRepository.save(pessoa__filme1);
       return objectMapper.convertValue(pessoa__filmeCriado, Pessoa_X_FilmeDTO.class);
    }


}
