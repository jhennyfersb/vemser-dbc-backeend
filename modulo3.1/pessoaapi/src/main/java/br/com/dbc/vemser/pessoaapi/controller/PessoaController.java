package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaDTO;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exception.BancoDeDadosException;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.PessoaService;
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



    @Value("${user}")
    private String usuario;

    @Value("${spring.aplication.name}")
    private String app;


    @GetMapping("/hello") // localhost:8080/pessoa/hello
    public String hello() {
        return "Hello world!";
    }

    /*@PostMapping // localhost:8080/pessoa
    public Pessoa create(@Valid @RequestBody Pessoa pessoa) throws Exception {
        return pessoaService.create(pessoa);
    }*/
    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        return pessoaService.list();
    }

    @GetMapping("/byname") // localhost:8080/pessoa/byname?nome=Rafa
    public List<PessoaDTO> listByName(@RequestParam("nome") String nome) {
        return pessoaService.listByName(nome);
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
