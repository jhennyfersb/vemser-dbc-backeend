package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.*;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.service.FilmeService;
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
@RequestMapping("/filme")
public class FilmeController {
    private final FilmeService filmeService;
    @Operation(summary = "listar filmes", description = "Lista todas os filmes do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de filmes"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping
    public List<FilmeDTO> list() {
        return filmeService.list();
    }
    @Operation(summary = "listar filme por id", description = "Lista todas os filmes do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de filmes"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @GetMapping("/{idFilme}")
    public List<FilmeDTO> listByNumber(@PathVariable("idFilme") Integer id) throws RegraDeNegocioException {
        return filmeService.listByFilme(id);
    }

    @Operation(summary = "cria filme", description = "adiciona filme no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna o filme adicionado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping
    public ResponseEntity<FilmeDTO> create(@Valid @RequestBody FilmeCreateDTO filmeCreateDTO) throws RegraDeNegocioException {
        log.info("criando filme...");
        FilmeDTO filmeDTO = filmeService.create(filmeCreateDTO);
        log.info("filme criado!");
        return new ResponseEntity<>(filmeDTO, HttpStatus.OK);
    }
    @Operation(summary = "atualiza filme", description = "atualiza filme do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna ok quando o filme for atualizado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PutMapping("/{idFilme}")
    public ResponseEntity<FilmeDTO> update(@PathVariable("idFilme") Integer id,
                                             @Valid @RequestBody FilmeCreateDTO filmeCreateDTO) throws RegraDeNegocioException {
        log.info("atualizando filme..");
        FilmeDTO filmeDTO = filmeService.update(id, filmeCreateDTO);
        log.info("filme atualizado");
        return new ResponseEntity<>(filmeDTO, HttpStatus.OK);
    }
    @Operation(summary = "deleta filme por id filme", description = "deleta filme do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna ok quando o filme for deletado"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @DeleteMapping("/{idFilme}")
    public ResponseEntity<FilmeDTO> delete(@Valid @PathVariable("idFilme") Integer idFilme) throws RegraDeNegocioException {
        log.info("deletando filme..");
        filmeService.delete(idFilme);
        log.info("filme deletado");
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "cria avaliação pelo id da pessoa", description = "adiciona avaliação no banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a avaliação adicionada"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/avaliacao/{idPessoa}")
    public ResponseEntity<pessoaFilmeDTO> avaliarFilme(@PathVariable("idPessoa") Integer idPessoa,
                                                       @Valid @RequestBody PessoaFilmeCreateDTO pessoa__filmeCreateDTO) throws RegraDeNegocioException {
        log.info("criando avaliaçao...");
        pessoaFilmeDTO pessoa_x_filmeDTO = filmeService.avaliarFilme(idPessoa, pessoa__filmeCreateDTO);
        log.info("avaliacao criada!");
        return new ResponseEntity<>(pessoa_x_filmeDTO, HttpStatus.OK);
    }
}
