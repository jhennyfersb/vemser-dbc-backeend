package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.ContatoEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public ContatoDTO findByContato(Integer id) throws RegraDeNegocioException {

      return objectMapper.convertValue(findByIDContatoEntity(id), ContatoDTO.class);
    }

    private ContatoEntity findByIDContatoEntity(Integer id) throws RegraDeNegocioException {
       return contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
    }

    public ContatoDTO create(ContatoCreateDTO contato) throws RegraDeNegocioException {
        //PessoaEntity pessoaEntityContato = pessoaService.findById(idPessoa);
        ContatoEntity contatoEntity = objectMapper.convertValue(contato, ContatoEntity.class);
        //contatoEntity.setIdPessoa(idPessoa);
        ContatoEntity contatoEntity1 = contatoRepository.save(contatoEntity);
        //emailService.sendEmail(pessoaEntityContato, "contato-template.ftl", pessoaEntityContato.getEmail());
        return objectMapper.convertValue(contatoEntity1, ContatoDTO.class);
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizarDTO) throws RegraDeNegocioException {
        //PessoaEntity pessoaEntityContato = pessoaService.findById(contatoAtualizarDTO.getIdPessoa());
        ContatoEntity contatoEntityRecuperado = findByIDContatoEntity(id);
        //pessoaService.findById(contatoAtualizarDTO.getIdPessoa());
        //contatoEntityRecuperado.setIdPessoa(contatoAtualizarDTO.getIdPessoa());
       // contatoEntityRecuperado.setTipoContato(contatoAtualizarDTO.getTipoContato());
        contatoEntityRecuperado.setNumero(contatoAtualizarDTO.getNumero());
        contatoEntityRecuperado.setDescricao(contatoAtualizarDTO.getDescricao());
        contatoRepository.save(contatoEntityRecuperado);
       // emailService.sendEmail(pessoaEntityContato, "contato-template-update.ftl", pessoaEntityContato.getEmail());
        return objectMapper.convertValue(contatoEntityRecuperado, ContatoDTO.class);
    }

    public List<ContatoDTO> buscarPorId(Integer pessoaId) {
        return null;
      /*  return contatoRepository.buscarPorId(pessoaId)
                .stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .collect(Collectors.toList());

       */
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        ContatoEntity contatoEntityDeletado = findByIDContatoEntity(id);
        //PessoaEntity pessoaEntityContato = pessoaService.findById(contatoEntityDeletado.getIdPessoa());
        //emailService.sendEmail(pessoaEntityContato, "contato-template-delete.ftl", pessoaEntityContato.getEmail());
        contatoRepository.delete(contatoEntityDeletado);
    }
}
