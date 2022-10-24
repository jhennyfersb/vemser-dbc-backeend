package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
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


    public List<ContatoDTO> list() {
        return contatoRepository.list()
                .stream()
                .map(contato -> objectMapper.convertValue(contato,ContatoDTO.class))
                .collect(Collectors.toList());
    }

    public ContatoDTO create(ContatoCreateDTO contato) throws RegraDeNegocioException {
        Contato contatoEntity = objectMapper.convertValue(contato, Contato.class);
        Contato contato1 = contatoRepository.create(contatoEntity);
        pessoaService.findById(contato.getIdPessoa());
        return objectMapper.convertValue(contato1, ContatoDTO.class);
    }

    private Contato findByID(Integer id) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return contatoRecuperado;
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizarDTO) throws RegraDeNegocioException {
        Contato contatoRecuperado = findByID(id);
        contatoRecuperado.setIdPessoa(contatoAtualizarDTO.getIdPessoa());
        contatoRecuperado.setTipoContato(contatoAtualizarDTO.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizarDTO.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizarDTO.getDescricao());
        return objectMapper.convertValue(contatoRecuperado, ContatoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Contato contatoDeletado = findByID(id);
        contatoRepository.delete(contatoDeletado);
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
}
