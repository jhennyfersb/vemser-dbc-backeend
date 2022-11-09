package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.PessoaRepository;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@Validated
@RequestMapping("/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;

    private final PessoaRepository pessoaRepository;


    @Value("${user}")
    private String usuario;

    @Value("${spring.aplication.name}")
    private String app;
    @Operation(summary = "listar pessoas pelo relatorio ", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("relatorio")
    public List<PessoaCompletaDTO>findAllPessoa(@RequestParam(required = false , name = "idPessoa")Integer idPessoa) {
        return pessoaService.findAllPessoa(idPessoa);
    }

    @Operation(summary = "listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @Operation(summary = "listar enderecos de pessoas pelo id", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas e lista de enderecos de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/listar-com-endereco")
    public List<PessoaComEnderecoDTO> listComEndereco(@RequestParam(required = false, name = "idPessoa") Integer idPessoa) {
        if (idPessoa != null) {
            return List.of(pessoaService.getPessoasComEnderecosPorId(idPessoa));
        } else {
            return pessoaService.listPessoasComEnderecos();
        }
    }

    @Operation(summary = "listar endereco de pessoas pelo id", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas e lista de endereco de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/listar-com-contatos")
    public List<PessoaComContatoDTO> listComContatos(@RequestParam(required = false, name = "idPessoa") Integer idPessoa) {
        if (idPessoa != null) {
            return List.of(pessoaService.getPessoaComContatosPorId(idPessoa));
        } else {
            return pessoaService.listPessoasComContatos();
        }
    }

    @Operation(summary = "listar filmes assistidos de pessoas pelo id", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas e lista de filmes assistidos de pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/listar-com-filmes-assistidos")
    public List<PessoaComFilmeAssistidoDTO> listComFilmesAssistidos(@RequestParam(required = false, name = "idPessoa") Integer idPessoa) {
        if (idPessoa != null) {
            return List.of(pessoaService.getPessoasComFilmesAssistidosPorId(idPessoa));
        } else {
            return pessoaService.listPessoasComFilmesAssistidos();
        }
    }

    @GetMapping("/{idPessoa}")
    public PessoaDTO findById(@PathVariable Integer idPessoa) {
        return pessoaService.getPorId(idPessoa);
    }

    @Operation(summary = "cria pessoa", description = "adiciona pessoa no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a pessoa adicionada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        log.info("criando pessoa...");
        PessoaDTO pessoaDTO = pessoaService.create(pessoaCreateDTO);
        log.info("pessoa criada!");
        return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
    }

    @Operation(summary = "atualizar dados da pessoa pelo id", description = "atualiza pessoa do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna pessoa atualizada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                            @Valid @RequestBody PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        log.info("atualizando pessoa.. ");
        PessoaDTO pessoaDTO = pessoaService.update(id, pessoaCreateDTO);
        log.info("pessoa atualizada");
        return pessoaDTO;
    }

    @Operation(summary = "deleta pessoa", description = "deleta pessoa do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna ok quando a pessoa for deletada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        log.info("deletando pessoa");
        pessoaService.delete(id);
        log.info("pessoa deletada");

    }

    @GetMapping("/por-endereco")
    public List<PessoaEntity> recuperarPessoasQueTemEnderecos(String nome) {
        return pessoaRepository.recuperarPessoasQueTemEnderecos(nome);
    }

}
