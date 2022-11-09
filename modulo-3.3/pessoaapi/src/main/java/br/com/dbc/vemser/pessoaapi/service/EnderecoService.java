package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class EnderecoService {
    private final EnderecoRepository enderecoRepository;
    private final PessoaService pessoaService;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;


    public List<EnderecoDTO> list() {
        return enderecoRepository.findAll()
                .stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoEntity findById(Integer idEndereco) throws RegraDeNegocioException {
        return enderecoRepository.findById(idEndereco)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));

    }
    public List<EnderecoDTO> listByEndereco(Integer id) {
        return enderecoRepository.findById(id)
                .stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .collect(Collectors.toList());
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityEndereco = pessoaService.findByIdPessoa(idPessoa);
        //PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntityEndereco,PessoaDTO.class);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);

        enderecoEntity.setPessoas(Set.of(pessoaEntityEndereco));
        pessoaEntityEndereco.setEnderecos(Set.of(enderecoEntity));

        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoRepository.save(enderecoEntity), EnderecoDTO.class);
        enderecoDTO.setIdPessoa(idPessoa);
       // emailService.sendEmail(pessoaEntityEndereco, "endereco-template.ftl", pessoaEntityEndereco.getEmail());
        return enderecoDTO;
    }

    public EnderecoDTO update(Integer id,
                              EnderecoCreateDTO enderecoAtualizarDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityEndereco = pessoaService.findByIdPessoa(enderecoAtualizarDTO.getIdPessoa());
        EnderecoEntity enderecoEntityRecuperado = findById(id);

        enderecoEntityRecuperado.getPessoas().clear();
        enderecoEntityRecuperado.getPessoas().add(pessoaEntityEndereco);

        enderecoEntityRecuperado.setTipo(enderecoAtualizarDTO.getTipo());
        enderecoEntityRecuperado.setLogradouro(enderecoAtualizarDTO.getLogradouro());
        enderecoEntityRecuperado.setComplemento(enderecoAtualizarDTO.getComplemento());
        enderecoEntityRecuperado.setNumero(enderecoAtualizarDTO.getNumero());
        enderecoEntityRecuperado.setCep(enderecoAtualizarDTO.getCep());
        enderecoEntityRecuperado.setCidade(enderecoAtualizarDTO.getCidade());
        enderecoEntityRecuperado.setPais(enderecoAtualizarDTO.getPais());

        enderecoRepository.save(enderecoEntityRecuperado);
        emailService.sendEmail(pessoaEntityEndereco, "endereco-template-update.ftl", pessoaEntityEndereco.getEmail());
        return objectMapper.convertValue(enderecoEntityRecuperado, EnderecoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntityDeletado = findById(id);
        //PessoaEntity pessoaEntityEndereco = pessoaService.findByIdPessoa(enderecoEntityDeletado.getIdPessoa());
        //emailService.sendEmail(pessoaEntityEndereco, "endereco-template-delete.ftl", pessoaEntityEndereco.getEmail());
        enderecoRepository.delete(enderecoEntityDeletado);
    }


}
