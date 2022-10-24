package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;


    public List<EnderecoDTO> list() {
        return enderecoRepository.list()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        Endereco enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
        Endereco endereco = enderecoRepository.create(enderecoEntity);
        pessoaService.findById(enderecoEntity.getIdPessoa());
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }

    public Endereco findById(Integer idEndereco) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));

        return enderecoRecuperado;
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = findById(id);
        enderecoRecuperado.setIdPessoa(enderecoAtualizar.getIdPessoa());
        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        return objectMapper.convertValue(enderecoAtualizar, EnderecoDTO.class);
    }

    public List<EnderecoDTO> listByEndereco(Integer id) {
        return enderecoRepository.listByEndereco(id)
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco enderecoDeletado = findById(id);
        enderecoRepository.delete(enderecoDeletado);
    }

    public List<EnderecoDTO> buscarPorId(String pessoaId) {
        return enderecoRepository.buscarPorId(Integer.parseInt(pessoaId))
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

}
