package br.com.dbc.vemser.pessoaapi.controller;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import org.springframework.web.bind.annotation.*;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import java.util.List;

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
    public Contato update(@PathVariable("idContato") Integer id,
                          @RequestBody Contato contatoAtualizar) throws Exception {
        return contatoService.update(id, contatoAtualizar);
    }

    @PostMapping("/{idPessoa}")
    public Contato create(@PathVariable("idPessoa")Integer idPessoa,
                          @RequestBody Contato contato) {
        contato.setIdPessoa(idPessoa);
        return contatoService.create(contato);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer idContato) throws Exception {
        contatoService.delete(idContato);
    }
}
