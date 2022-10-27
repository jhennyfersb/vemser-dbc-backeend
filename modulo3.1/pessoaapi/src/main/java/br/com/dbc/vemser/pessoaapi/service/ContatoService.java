package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        return contatoRepository.list()
                .stream()
                .map(contato -> objectMapper.convertValue(contato,ContatoDTO.class))
                .collect(Collectors.toList());
    }
    public List<ContatoDTO> listByNumber(Integer id) {
        return contatoRepository.listByNumber(id)
                .stream()
                .map(contato -> objectMapper.convertValue(contato,ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public List<ContatoDTO> buscarPorId(Integer pessoaId) {
        return contatoRepository.buscarPorId(pessoaId)
                .stream()
                .map(contato -> objectMapper.convertValue(contato,ContatoDTO.class))
                .collect(Collectors.toList());
    }

    private Contato findByID(Integer id) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return contatoRecuperado;
    }

    public ContatoDTO create(Integer idPessoa,ContatoCreateDTO contato) throws RegraDeNegocioException {
        Pessoa pessoaContato = pessoaService.findById(idPessoa);
        Contato contatoEntity = objectMapper.convertValue(contato, Contato.class);
        contatoEntity.setIdPessoa(idPessoa);
        Contato contato1 = contatoRepository.create(contatoEntity);
        emailService.sendEmail(pessoaContato,"contato-template.ftl",pessoaContato.getEmail());
        return objectMapper.convertValue(contato1, ContatoDTO.class);
    }
    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizarDTO) throws RegraDeNegocioException {
        Pessoa pessoaContato = pessoaService.findById(contatoAtualizarDTO.getIdPessoa());
        Contato contatoRecuperado = findByID(id);
        pessoaService.findById(contatoAtualizarDTO.getIdPessoa());
        contatoRecuperado.setIdPessoa(contatoAtualizarDTO.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizarDTO.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizarDTO.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizarDTO.getDescricao());
        emailService.sendEmail(pessoaContato,"contato-template-update.ftl",pessoaContato.getEmail());
        return objectMapper.convertValue(contatoRecuperado, ContatoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Contato contatoDeletado = findByID(id);
        Pessoa pessoaContato = pessoaService.findById(contatoDeletado.getIdPessoa());
        emailService.sendEmail(pessoaContato,"contato-template-delete.ftl",pessoaContato.getEmail());
        contatoRepository.delete(contatoDeletado);
    }
}
