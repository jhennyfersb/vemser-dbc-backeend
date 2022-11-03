package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.controller.PessoaController;
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

    public List<PessoaDTO> list() {
        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .collect(Collectors.toList());
    }
    public List<PessoaComContatoDTO> listPessoasComContatos() {

        return pessoaRepository.findAll()
                .stream()
                .map(pessoa -> {
                    List<ContatoDTO> contatoDTOS = pessoa.getContatos()
                            .stream()
                            .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                            .toList();
                    PessoaComContatoDTO pessoaComContatoDTO = objectMapper.convertValue(pessoa, PessoaComContatoDTO.class);
                    pessoaComContatoDTO.setContatos(contatoDTOS);
                    return pessoaComContatoDTO;
                })
                .collect(Collectors.toList());
    }
    public List<PessoaComEnderecoDTO> listPessoasComEnderecos(){
        return pessoaRepository.findAll()
                .stream()
                .map(pessoaEntity -> {
                    List<EnderecoDTO> enderecoDTOS = pessoaEntity.getEnderecos()
                            .stream()
                            .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity,EnderecoDTO.class))
                            .toList();
                    PessoaComEnderecoDTO pessoaEnderecoDTO = objectMapper.convertValue(pessoaEntity,PessoaComEnderecoDTO.class);
                    pessoaEnderecoDTO.setEnderecos(enderecoDTOS);
                    return pessoaEnderecoDTO;
                })
                .collect(Collectors.toList());
    }
    public List<PessoaComFilmeAssistidoDTO> listPessoasComFilmesAssistidos(){
        return pessoaRepository.findAll()
                .stream()
                .map(pessoaEntity -> {
                    List<Pessoa_X_FilmeDTO> pessoaComFilmesDTOS = pessoaEntity.getPessoaXFilmes()
                            .stream()
                            .map(filmeEntity -> objectMapper.convertValue(filmeEntity,Pessoa_X_FilmeDTO.class))
                            .toList();
                    PessoaComFilmeAssistidoDTO pessoaComFilmesDTO = objectMapper.convertValue(pessoaComFilmesDTOS,PessoaComFilmeAssistidoDTO.class);
                    pessoaComFilmesDTO.setListPessoa_x_filmeDTO(pessoaComFilmesDTOS);
                    return pessoaComFilmesDTO;
                })
                .collect(Collectors.toList());
    }

    PessoaEntity findByIdPessoa(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public PessoaDTO getPorId(Integer idPessoa) {
        PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa).get();
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
    }
    public PessoaComContatoDTO getPessoaComContatosPorId(Integer idPessoa) {
        PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa).get();
        List<ContatoDTO> contatoDTOS = pessoaEntity.getContatos()
                .stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .toList();
        PessoaComContatoDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaComContatoDTO.class);
        pessoaDTO.setContatos(contatoDTOS);
        return pessoaDTO;
    }
    public PessoaComEnderecoDTO getPessoasComEnderecosPorId(Integer idPessoa){
        PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa).get();
        List<EnderecoDTO> enderecoDTOS = pessoaEntity.getEnderecos()
                .stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity,EnderecoDTO.class))
                .toList();
        PessoaComEnderecoDTO pessoaEnderecoDTo = objectMapper.convertValue(pessoaEntity,PessoaComEnderecoDTO.class);
        pessoaEnderecoDTo.setEnderecos(enderecoDTOS);
        return pessoaEnderecoDTo;
    }
    public PessoaComFilmeAssistidoDTO getPessoasComFilmesAssistidosPorId(Integer idPessoa){
        PessoaEntity pessoaEntity = pessoaRepository.findById(idPessoa).get();
        List<Pessoa_X_FilmeDTO> filmeDTOS = pessoaEntity.getPessoaXFilmes()
                .stream()
                .map(pessoaXFilme -> new Pessoa_X_FilmeDTO(pessoaXFilme.getPessoaFilmeId().getIdFilme(),
                        idPessoa,
                        pessoaXFilme.getDateAssistido(),
                        pessoaXFilme.getDescricao(),
                        pessoaXFilme.getNota()))
                .toList();
        PessoaComFilmeAssistidoDTO pessoaComFilmesDTO = objectMapper.convertValue(pessoaEntity,PessoaComFilmeAssistidoDTO.class);
        pessoaComFilmesDTO.setListPessoa_x_filmeDTO(filmeDTOS);
        return pessoaComFilmesDTO;
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
}