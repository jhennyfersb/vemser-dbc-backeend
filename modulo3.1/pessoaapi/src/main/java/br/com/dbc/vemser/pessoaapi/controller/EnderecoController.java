package br.com.dbc.vemser.pessoaapi.controller;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }
    @GetMapping
    public List<Endereco> list(){
        return enderecoService.list();
    }
    @GetMapping("/{idEndereco}")
    public List<Endereco> listByEndereco(@PathVariable("idEndereco")Integer id){
        return enderecoService.listByEndereco(id);
    }
    @GetMapping("/{idPessoa}/pessoa")
    public List<Endereco> listPessoaId(@PathVariable("idPessoa")String id){
        return enderecoService.buscarPorId(id);
    }
    @PostMapping("/{idEndereco}")
    public Endereco create(@PathVariable("idEndereco")Integer id,
                           @RequestBody Endereco endereco){
        endereco.setIdPessoa(id);
        return enderecoService.create(endereco);
    }
    @PutMapping("/{idEndereco}")
    public Endereco update(@PathVariable("idEndereco")Integer id,
                           @RequestBody Endereco enderecoAtualizar) throws Exception {
        return enderecoService.update(id,enderecoAtualizar);
    }
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco")Integer id) throws Exception {
        enderecoService.delete(id);
    }
}
