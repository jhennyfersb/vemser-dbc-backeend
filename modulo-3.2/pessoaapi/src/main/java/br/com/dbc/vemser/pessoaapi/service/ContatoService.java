package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final PessoaService pessoaService;

    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public List<ContatoDTO> list() {
        return contatoRepository.findAll()
                .stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> listByContato(Integer id) throws RegraDeNegocioException {

        return Collections.singletonList(objectMapper.convertValue(findByIdContato(id), ContatoDTO.class));
    }

    private ContatoEntity findByIdContato(Integer id) throws RegraDeNegocioException {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
    }

    public ContatoDTO create(Integer idPessoa,ContatoCreateDTO contato) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityContato = pessoaService.findByIdPessoa(idPessoa);

        ContatoEntity contatoEntity = objectMapper.convertValue(contato, ContatoEntity.class);
        contatoEntity.setIdPessoa(idPessoa);
        ContatoEntity contatoEntity1 = contatoRepository.save(contatoEntity);
        emailService.sendEmail(pessoaEntityContato, "contato-template.ftl", pessoaEntityContato.getEmail());
        return objectMapper.convertValue(contatoEntity1, ContatoDTO.class);
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizarDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityContato = pessoaService.findByIdPessoa(contatoAtualizarDTO.getIdPessoa());
        ContatoEntity contatoEntityRecuperado = findByIdContato(id);

        contatoEntityRecuperado.setNumero(contatoAtualizarDTO.getNumero());
        contatoEntityRecuperado.setIdPessoa(contatoAtualizarDTO.getIdPessoa());
        contatoEntityRecuperado.setTipoContato(contatoAtualizarDTO.getTipoContato());
        contatoEntityRecuperado.setDescricao(contatoAtualizarDTO.getDescricao());

        contatoRepository.save(contatoEntityRecuperado);
        emailService.sendEmail(pessoaEntityContato, "contato-template-update.ftl", pessoaEntityContato.getEmail());
        return objectMapper.convertValue(contatoEntityRecuperado, ContatoDTO.class);
    }

    public List<ContatoDTO> buscarPorId(Integer id) {
        contatoRepository.findById(id);
        return null;
      /*  return contatoRepository.buscarPorId(pessoaId)
                .stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());

       */
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoEntityDeletado = findByIdContato(id);
        PessoaEntity pessoaEntityContato = pessoaService.findByIdPessoa(contatoEntityDeletado.getIdPessoa());
        emailService.sendEmail(pessoaEntityContato, "contato-template-delete.ftl", pessoaEntityContato.getEmail());
        contatoRepository.delete(contatoEntityDeletado);
    }
}
