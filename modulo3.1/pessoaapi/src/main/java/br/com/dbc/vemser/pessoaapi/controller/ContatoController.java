package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Validated
@RestController
@RequestMapping("/contato")
public class ContatoController {
    private final ContatoService contatoService;


    @GetMapping("/hello ")
    public String hello() {
        return "hello word";
    }

    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }

    @GetMapping("/{idContato}")
    public List<ContatoDTO> listByNumber(@PathVariable("idContato") Integer id) {
        return contatoService.listByNumber(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<ContatoDTO> listPessoaId(@PathVariable("idPessoa") Integer id) {
        return contatoService.buscarPorId(id);
    }

    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                                             @Valid @RequestBody ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        log.info("atualizando contato..");
        ContatoDTO contatoDTO = contatoService.update(id, contatoCreateDTO);
        log.info("contato atualizado");
        return new ResponseEntity<>(contatoDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ContatoDTO> create(@Valid @RequestBody ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        log.info("criando contato...");
        ContatoDTO contatoDTO = contatoService.create(contatoCreateDTO);
        log.info("contato criado!");
        return new ResponseEntity<>(contatoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{idContato}")
    public ResponseEntity<Contato> delete(@Valid @PathVariable("idContato") Integer idContato) throws RegraDeNegocioException {
        log.info("deletando pessoa..");
        contatoService.delete(idContato);
        log.info("pessoa deletada");
        return ResponseEntity.noContent().build();
    }
}
