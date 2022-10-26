package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;


    public List<EnderecoDTO> list() {
        return enderecoRepository.list()
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> listByEndereco(Integer id) {
        return enderecoRepository.listByEndereco(id)
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public List<EnderecoDTO> buscarPorId(String pessoaId) {
        return enderecoRepository.buscarPorId(Integer.parseInt(pessoaId))
                .stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .collect(Collectors.toList());
    }
    public Endereco findById(Integer idEndereco) throws RegraDeNegocioException {
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));

        return enderecoRecuperado;
    }
    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        Pessoa pessoaEndereco = pessoaService.findById(idPessoa);
        Endereco enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, Endereco.class);
        Endereco endereco = enderecoRepository.create(enderecoEntity);
        endereco.setIdPessoa(idPessoa);
        emailService.sendEmail(pessoaEndereco, "endereco-template.ftl", pessoaEndereco.getEmail());
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer id,
                              EnderecoCreateDTO enderecoAtualizarDTO) throws RegraDeNegocioException {
        Pessoa pessoaEndereco = pessoaService.findById(enderecoAtualizarDTO.getIdPessoa());
        Endereco enderecoRecuperado = findById(id);
        enderecoRecuperado.setIdPessoa(enderecoAtualizarDTO.getIdPessoa());
        enderecoRecuperado.setTipo(enderecoAtualizarDTO.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizarDTO.getLogradouro());
        enderecoRecuperado.setComplemento(enderecoAtualizarDTO.getComplemento());
        enderecoRecuperado.setNumero(enderecoAtualizarDTO.getNumero());
        enderecoRecuperado.setCep(enderecoAtualizarDTO.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizarDTO.getCidade());
        enderecoRecuperado.setPais(enderecoAtualizarDTO.getPais());

        emailService.sendEmail(pessoaEndereco, "endereco-template-update.ftl", pessoaEndereco.getEmail());
        return objectMapper.convertValue(enderecoRecuperado, EnderecoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco enderecoDeletado = findById(id);
        Pessoa pessoaEndereco = pessoaService.findById(enderecoDeletado.getIdPessoa());
        emailService.sendEmail(pessoaEndereco, "endereco-template-delete.ftl", pessoaEndereco.getEmail());
        enderecoRepository.delete(enderecoDeletado);
    }

}
