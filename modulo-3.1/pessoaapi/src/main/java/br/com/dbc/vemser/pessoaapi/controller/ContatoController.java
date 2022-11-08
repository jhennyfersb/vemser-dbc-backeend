package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.ContatoDTO;
import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.ContatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(hidden = true)
    @GetMapping("/hello ")
    public String hello() {
        return "hello word";
    }
    @Operation(summary = "listar contato", description = "Lista todas os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<ContatoDTO> list() {
        return contatoService.list();
    }
    @Operation(summary = "listar contato por id", description = "Lista todas os contatos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idContato}")
    public List<ContatoDTO> listByNumber(@PathVariable("idContato") Integer id) {
        return contatoService.listByNumber(id);
    }
    @Operation(summary = "listar todos contatos por id da pessoa", description = "Lista todas os contatos do banco com o id da pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de contatos da pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idPessoa}/pessoa")
    public List<ContatoDTO> listPessoaId(@PathVariable("idPessoa") Integer id) {
        return contatoService.buscarPorId(id);
    }
    @Operation(summary = "cria contato por id da pessoa", description = "adiciona contato no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o contato adicionado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/{idPessoa}")
    public ResponseEntity<ContatoDTO> create(@PathVariable("idPessoa") Integer idPessoa,
            @Valid @RequestBody ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        log.info("criando contato...");
        ContatoDTO contatoDTO = contatoService.create(idPessoa,contatoCreateDTO);
        log.info("contato criado!");
        return new ResponseEntity<>(contatoDTO, HttpStatus.OK);
    }
    @Operation(summary = "atualizar dados do contato por id contato", description = "atualiza contato do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna contato atualizado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idContato}")
    public ResponseEntity<ContatoDTO> update(@PathVariable("idContato") Integer id,
                                             @Valid @RequestBody ContatoCreateDTO contatoCreateDTO) throws RegraDeNegocioException {
        log.info("atualizando contato..");
        ContatoDTO contatoDTO = contatoService.update(id, contatoCreateDTO);
        log.info("contato atualizado");
        return new ResponseEntity<>(contatoDTO, HttpStatus.OK);
    }
    @Operation(summary = "deleta contato por id contato", description = "deleta contato do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna ok quando o contato for deletado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idContato}")
    public ResponseEntity<Contato> delete(@Valid @PathVariable("idContato") Integer idContato) throws RegraDeNegocioException {
        log.info("deletando pessoa..");
        contatoService.delete(idContato);
        log.info("pessoa deletada");
        return ResponseEntity.noContent().build();
    }
}
