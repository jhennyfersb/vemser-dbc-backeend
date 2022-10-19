package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import org.springframework.web.bind.annotation.*;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;

import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    private ContatoService contatoService;

    public ContatoController() {
        contatoService = new ContatoService();
    }

    @GetMapping("/hello ")
    public String hello() {
        return "hello word";
    }

    @PostMapping
    public Contato create(@RequestBody Contato contato) {
        return contatoService.create(contato);
    }

    @GetMapping
    public List<Contato> list() {
        return contatoService.list();
    }

    @GetMapping("/pessoa")
    public Contato byPessoaId(@RequestParam("idPessoa") String id) {
        return contatoService.buscarPorId(id);
    }

    @GetMapping("/bynumero")
    public List<Contato> listByNumber(@RequestParam("numero") String numero) {
        return contatoService.listByNumber(numero);
    }

    @PutMapping("/{idContato}")
    public Contato update(@PathVariable("idContato") Integer id,
                          @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer idContato) throws Exception {
        contatoService.delete(idContato);
    }
}
