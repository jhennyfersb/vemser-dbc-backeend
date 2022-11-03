package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.dbc.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "listar enderecos", description = "Lista todas os enderecos do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de enderecos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<EnderecoDTO> list() {
        return enderecoService.list();
    }

    @Operation(summary = "listar enderecos por id", description = "Lista todas os enderecos do banco ")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de enderecos"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping("/{idEndereco}")
    public List<EnderecoDTO> listByEndereco(@PathVariable("idEndereco") Integer id) {
        return enderecoService.listByEndereco(id);
    }

    @Operation(summary = "listar todos enderecos por id da pessoa", description = "Lista todos os enderecos do banco com o id da pessoa")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de enderecos da pessoa"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )

    @GetMapping("/{idPessoa}/pessoa")
    public List<EnderecoDTO> listPessoaId(@PathVariable("idPessoa") Integer id) {
        return enderecoService.listByEndereco(id);
    }

    @Operation(summary = "cria endereco ", description = "adiciona endereco no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o endereco adicionado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    public ResponseEntity<EnderecoDTO> create(@Valid @RequestBody EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        log.info("criando endereço..");
        EnderecoDTO enderecoDTO = enderecoService.create(endereco);
        log.info("endereço criado ...");
        return new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
    }

    @Operation(summary = "atualizar dados do endereco por id endereco", description = "atualiza endereco do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna endereco atualizado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idEndereco}")
    public ResponseEntity<EnderecoDTO> update(@PathVariable("idEndereco") Integer id,
                                              @Valid @RequestBody EnderecoCreateDTO enderecoAtualizar) throws RegraDeNegocioException {
        log.info("atualizando endereço..");
        EnderecoDTO enderecoDTO = enderecoService.update(id, enderecoAtualizar);
        log.info("Endereço atualizado");
        return new ResponseEntity<>(enderecoDTO, HttpStatus.OK);
    }

    @Operation(summary = "deleta endereco por id endereco", description = "deleta endereco do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna ok quando o endereco for deletado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idEndereco}")
    public void delete(@PathVariable("idEndereco") Integer id) throws RegraDeNegocioException {
        log.info("deletando endereço..");
        enderecoService.delete(id);
        log.info("Endereço deletado");
    }
}
