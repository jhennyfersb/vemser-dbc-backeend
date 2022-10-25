package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    @GetMapping("/{idEndereco}")
    public List<EnderecoDTO> listByEndereco(@PathVariable("idEndereco") Integer id) {
        return enderecoService.listByEndereco(id);
    }

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listPessoaId(@PathVariable("idPessoa") String id) {
        return enderecoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<EnderecoDTO> create(@Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        log.info("criando endereço..");
        EnderecoDTO enderecoDTO = enderecoService.create(endereco);
        log.info("endereço criado ...");
        return new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
    }

    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                                              @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        log.info("atualizando endereço..");
        EnderecoDTO enderecoDTO = enderecoService.update(id, enderecoAtualizar);
        log.info("Endereço atualizado");
        return new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        log.info("deletando endereço..");
        enderecoService.delete(id);
        log.info("Endereço deletado");
    }
}
