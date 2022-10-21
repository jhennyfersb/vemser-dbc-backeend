package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/contato")
public class ContatoController {
    private final ContatoService contatoService;

    public ContatoController(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping("/hello ")
    public String hello() {
        return "hello word";
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/{idContato}")
    public List<Contato> listByNumber(@PathVariable("idContato") Integer id) {
        return contatoService.listByNumber(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<Contato> listPessoaId(@PathVariable("idPessoa") Integer id) {
        return contatoService.buscarPorId(id);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<Contato> update(@PathVariable("idContato") Integer id,
                                          @Valid @RequestBody Contato contatoAtualizar) throws RegraDeNegocioException {
        return new ResponseEntity<>(contatoService.update(id, contatoAtualizar), HttpStatus.OK);
    }

    @PostMapping
    public Contato create(@Valid @RequestBody Contato contato) throws RegraDeNegocioException {
        return contatoService.create(contato);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Contato> delete(@Valid @PathVariable("idContato") Integer idContato) throws RegraDeNegocioException {
        contatoService.delete(idContato);
        return ResponseEntity.noContent().build();
    }
}
