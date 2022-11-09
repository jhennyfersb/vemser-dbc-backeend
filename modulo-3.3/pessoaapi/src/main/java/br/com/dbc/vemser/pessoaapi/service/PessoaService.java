package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.*;
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

    public PessoaEntity findByIdPessoa(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    private PessoaComContatoDTO getPessoaComContatoDTO(PessoaEntity pessoa) {
        List<ContatoDTO> contatoDTOS = getContatosDTOPorPessoa(pessoa);
        PessoaComContatoDTO pessoaComContatoDTO = objectMapper.convertValue(pessoa, PessoaComContatoDTO.class);
        pessoaComContatoDTO.setContatos(contatoDTOS);
        return pessoaComContatoDTO;
    }

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }

    public List<PessoaComContatoDTO> listPessoasComContatos() {

        return pessoaRepository.findAll()
                .stream()
                .map(this::getPessoaComContatoDTO)
                .collect(Collectors.toList());
    }

    private List<ContatoDTO> getContatosDTOPorPessoa(PessoaEntity pessoaEntity) {
        return pessoaEntity.getContatos()
                .stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .toList();
    }

    public PessoaComContatoDTO getPessoaComContatosPorId(Integer idPessoa) {
        PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa).get();
        return getPessoaComContatoDTO(pessoaEntity);
    }

    private PessoaComEnderecoDTO getPessoaComEnderecoDTO(PessoaEntity pessoaEntity) {
        List<EnderecoDTO> enderecoDTOS = getEnderecosDTOPorPessoa(pessoaEntity);
        PessoaComEnderecoDTO pessoaEnderecoDTO = objectMapper.convertValue(pessoaEntity, PessoaComEnderecoDTO.class);
        pessoaEnderecoDTO.setEnderecos(enderecoDTOS);
        return pessoaEnderecoDTO;
    }

    public List<PessoaComEnderecoDTO> listPessoasComEnderecos() {
        return pessoaRepository.findAll()
                .stream()
                .map(this::getPessoaComEnderecoDTO)
                .collect(Collectors.toList());
    }

    private List<EnderecoDTO> getEnderecosDTOPorPessoa(PessoaEntity pessoaEntity) {
        return pessoaEntity.getEnderecos()
                .stream()
                .map(enderecoEntity -> {
                    EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
                    enderecoDTO.setIdPessoa(pessoaEntity.getIdPessoa());
                    return enderecoDTO;
                })
                .toList();
    }

    public PessoaComEnderecoDTO getPessoasComEnderecosPorId(Integer idPessoa) {
        PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa).get();
        return getPessoaComEnderecoDTO(pessoaEntity);
    }


    private PessoaComFilmeAssistidoDTO getPessoaComFilmeAssistidoDTO(PessoaEntity pessoaEntity) {
        List<pessoaFilmeDTO> pessoaComFilmesDTOS = getFilmeDTOPorPessoa(pessoaEntity.getIdPessoa(), pessoaEntity);
        return new PessoaComFilmeAssistidoDTO(pessoaEntity.getNome(),
                pessoaEntity.getDataNascimento(),
                pessoaEntity.getEmail(),
                pessoaEntity.getCpf(),
                pessoaEntity.getIdPessoa(),
                pessoaComFilmesDTOS);
    }

    public List<PessoaComFilmeAssistidoDTO> listPessoasComFilmesAssistidos() {
        return pessoaRepository.findAll()
                .stream()
                .map(this::getPessoaComFilmeAssistidoDTO)
                .collect(Collectors.toList());
    }


    public PessoaComFilmeAssistidoDTO getPessoasComFilmesAssistidosPorId(Integer idPessoa) {
        PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa).get();
        List<pessoaFilmeDTO> filmeDTOS = getFilmeDTOPorPessoa(idPessoa, pessoaEntity);
        PessoaComFilmeAssistidoDTO pessoaComFilmesDTO = objectMapper.convertValue(pessoaEntity,
                PessoaComFilmeAssistidoDTO.class);
        pessoaComFilmesDTO.setPessoaFilmes(filmeDTOS);
        return pessoaComFilmesDTO;
    }


    private static List<pessoaFilmeDTO> getFilmeDTOPorPessoa(Integer idPessoa, PessoaEntity pessoaEntity) {
        return pessoaEntity.getPessoaXFilmes()
                .stream()
                .map(pessoaXFilme -> new pessoaFilmeDTO(pessoaXFilme.getPessoaFilmeId().getIdFilme(),
                        idPessoa,
                        pessoaXFilme.getDateAssistido(),
                        pessoaXFilme.getDescricao(),
                        pessoaXFilme.getNota()))
                .toList();
    }

    public PessoaDTO getPorId(Integer idPessoa) {
        PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa).get();
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
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
        PessoaEntity pessoaEntityRecuperada = findByIdPessoa(id);
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
        PessoaEntity pessoaEntityRecuperada = findByIdPessoa(id);
        pessoaRepository.deleteById(pessoaEntityRecuperada.getIdPessoa());
        //emailService.sendEmail(pessoaEntityRecuperada,
        // "email-template-delete.ftl",
        // pessoaEntityRecuperada.getEmail());
    }

    public List<PessoaCompletaDTO> findAllPessoa(Integer idPessoa) {
        return pessoaRepository.findAllPessoa(idPessoa);
    }
}