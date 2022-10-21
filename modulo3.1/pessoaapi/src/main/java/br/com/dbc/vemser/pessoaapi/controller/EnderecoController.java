package br.com.dbc.vemser.pessoaapi.controller;
import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@Validated
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
    @PostMapping
    public Endereco create(@Valid @RequestBody Endereco endereco)throws RegraDeNegocioException{
        return enderecoService.create(endereco);
    }
    @PutMapping("/{idEndereco}")
    public ResponseEntity<Endereco> update(@PathVariable("idEndereco")Integer id,
                                          @Valid @RequestBody Endereco enderecoAtualizar) throws RegraDeNegocioException {
        return new ResponseEntity<>(enderecoService.update(id,enderecoAtualizar), HttpStatus.OK);
    }
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco")Integer id) throws RegraDeNegocioException{
        enderecoService.delete(id);
    }
}
