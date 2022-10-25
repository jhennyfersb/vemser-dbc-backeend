package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final ObjectMapper objectMapper;
    private final EmailService emailService;

    public PessoaDTO create(PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoa1 = pessoaRepository.create(pessoaEntity);
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa1.getNome());
        dados.put("id", pessoa1.getIdPessoa());
        dados.put("email", pessoa1.getEmail());
        emailService.sendEmail(dados, "email-template.ftl");
        return objectMapper.convertValue(pessoa1, PessoaDTO.class);
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.list()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    Pessoa findById(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public PessoaDTO update(Integer id,
                            PessoaCreateDTO pessoaAtualizarDTO) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = findById(id);
        pessoaRecuperada.setCpf(pessoaAtualizarDTO.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizarDTO.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizarDTO.getDataNascimento());
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaRecuperada.getNome());
        dados.put("email", pessoaRecuperada.getEmail());
        emailService.sendEmail(dados, "email-template-update.ftl");
        return objectMapper.convertValue(pessoaRecuperada, PessoaDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = findById(id);
        pessoaRepository.delete(pessoaRecuperada);
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaRecuperada.getNome());
        dados.put("email", pessoaRecuperada.getEmail());
        emailService.sendEmail(dados, "email-template-delete.ftl");
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.listByName(nome)
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }
}
