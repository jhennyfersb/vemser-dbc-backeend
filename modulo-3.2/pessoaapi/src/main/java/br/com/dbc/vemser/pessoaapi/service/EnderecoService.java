package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
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
    public EnderecoDTO create(EnderecoCreateDTO enderecoCreateDTO) throws RegraDeNegocioException {
        //PessoaEntity pessoaEntityEndereco = pessoaService.findById(idPessoa);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(enderecoCreateDTO, EnderecoEntity.class);
        EnderecoEntity endereco = enderecoRepository.save(enderecoEntity);
        //endereco.setIdPessoa(idPessoa);
        //emailService.sendEmail(pessoaEntityEndereco, "endereco-template.ftl", pessoaEntityEndereco.getEmail());
        return objectMapper.convertValue(endereco, EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer id,
                              EnderecoCreateDTO enderecoAtualizarDTO) throws RegraDeNegocioException {
        //PessoaEntity pessoaEntityEndereco = pessoaService.findById(enderecoAtualizarDTO.getIdPessoa());
        EnderecoEntity enderecoEntityRecuperado = findById(id);
       // enderecoEntityRecuperado.setIdPessoa(enderecoAtualizarDTO.getIdPessoa());
        enderecoEntityRecuperado.setTipo(enderecoAtualizarDTO.getTipo());
        enderecoEntityRecuperado.setLogradouro(enderecoAtualizarDTO.getLogradouro());
        enderecoEntityRecuperado.setComplemento(enderecoAtualizarDTO.getComplemento());
        enderecoEntityRecuperado.setNumero(enderecoAtualizarDTO.getNumero());
        enderecoEntityRecuperado.setCep(enderecoAtualizarDTO.getCep());
        enderecoEntityRecuperado.setCidade(enderecoAtualizarDTO.getCidade());
        enderecoEntityRecuperado.setPais(enderecoAtualizarDTO.getPais());
        enderecoRepository.save(enderecoEntityRecuperado);
        //emailService.sendEmail(pessoaEntityEndereco, "endereco-template-update.ftl", pessoaEntityEndereco.getEmail());
        return objectMapper.convertValue(enderecoEntityRecuperado, EnderecoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntityDeletado = findById(id);
       // PessoaEntity pessoaEntityEndereco = pessoaService.findById(enderecoEntityDeletado.getIdPessoa());
        //emailService.sendEmail(pessoaEntityEndereco, "endereco-template-delete.ftl", pessoaEntityEndereco.getEmail());
        enderecoRepository.delete(enderecoEntityDeletado);
    }
    /*
        public List<EnderecoDTO> buscarPorId(String pessoaId) {
            return null;
                    //enderecoRepository.buscarPorId(Integer.parseInt(pessoaId))
                    //.stream()
                    //.map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                    //.collect(Collectors.toList());
        }*/
}
