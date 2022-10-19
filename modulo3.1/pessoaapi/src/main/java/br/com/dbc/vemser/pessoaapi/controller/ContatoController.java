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

    @GetMapping("/{idPessoa}")
    public List<Contato> byPessoaId(@PathVariable("idPessoa") String id) {
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

    @PostMapping("/{idPessoa}")
    public Contato create(@PathVariable("idPessoa")String idPessoa,
                          @RequestBody Contato contato) {
        contato.setIdPessoa(Integer.parseInt(idPessoa));
        return contatoService.create(contato);
    }

    @DeleteMapping("/{idContato}")
    public void delete(@PathVariable("idContato") Integer idContato) throws Exception {
        contatoService.delete(idContato);
    }
}
