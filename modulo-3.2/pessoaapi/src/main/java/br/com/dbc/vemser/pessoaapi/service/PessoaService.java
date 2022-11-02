package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public List<PessoaDTO> listById(Integer idPessoa) {
      return pessoaRepository.findById(idPessoa)
             .stream()
              .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
               .collect(Collectors.toList());
    }

    public PessoaDTO create(PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoa, PessoaEntity.class);
        PessoaEntity pessoaEntity1 = pessoaRepository.save(pessoaEntity);
        //Map<String, Object> dados = new HashMap<>();
       // dados.put("nome", pessoaEntity1.getNome());
        //dados.put("id", pessoaEntity1.getIdPessoa());
        //emailService.sendEmail(pessoaEntity1,
               // "email-template.ftl",
                //pessoaEntity1.getEmail());
        return objectMapper.convertValue(pessoaEntity1, PessoaDTO.class);
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizarDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityRecuperada = findById(id);
        pessoaEntityRecuperada.setCpf(pessoaAtualizarDTO.getCpf());
        pessoaEntityRecuperada.setNome(pessoaAtualizarDTO.getNome());
        pessoaEntityRecuperada.setDataNascimento(pessoaAtualizarDTO.getDataNascimento());
        pessoaRepository.save(pessoaEntityRecuperada);
       // emailService.sendEmail(pessoaEntityRecuperada,
                //"email-template-update.ftl",
               // pessoaEntityRecuperada.getEmail());
        return objectMapper.convertValue(pessoaEntityRecuperada, PessoaDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntityRecuperada = findById(id);
        pessoaRepository.deleteById(pessoaEntityRecuperada.getIdPessoa());
        //emailService.sendEmail(pessoaEntityRecuperada,
               // "email-template-delete.ftl",
               // pessoaEntityRecuperada.getEmail());
    }
}