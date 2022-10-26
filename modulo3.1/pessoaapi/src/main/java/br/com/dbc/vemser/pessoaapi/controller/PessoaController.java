package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EmailService;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

    private final EmailService emailService;

    @Value("${user}")
    private String usuario;

    @Value("${spring.aplication.name}")
    private String app;

    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        log.trace("A Trace Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
        try {
            emailService.sendSimpleMessage();
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Hello world!";
    }

    /*@PostMapping // localhost:8080/pessoa
    public Pessoa create(@Valid @RequestBody Pessoa pessoa) throws Exception {
        return pessoaService.create(pessoa);
    }*/
    @Operation(summary = "listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @GetMapping("/{idPessoa}")
    public List<PessoaDTO> listByPessoa(@PathVariable("idPessoa") Integer idpessoa) {
        return pessoaService.listById(idpessoa);
    }

    @PostMapping
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        log.info("criando pessoa...");
        PessoaDTO pessoaDTO = pessoaService.create(pessoaCreateDTO);
        log.info("pessoa criada!");
        return new ResponseEntity<>(pessoaDTO, HttpStatus.OK);
    }

    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public PessoaDTO update(@PathVariable("idPessoa") Integer id,
                        @Valid @RequestBody PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        log.info("atualizando pessoa.. ");
        PessoaDTO pessoaDTO = pessoaService.update(id,pessoaCreateDTO);
        log.info("pessoa atualizada");
        return pessoaDTO;
    }

    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws Exception {
        log.info("deletando pessoa");
        pessoaService.delete(id);
        log.info("pessoa deletada");

    }
}
