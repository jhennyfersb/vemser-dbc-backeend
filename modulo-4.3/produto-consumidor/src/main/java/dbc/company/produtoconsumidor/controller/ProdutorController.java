package dbc.company.produtoconsumidor.controller;

import dbc.company.produtoconsumidor.service.ProdutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
public class ProdutorController {
    private final ProdutorService produtorService;

    @Operation(summary = "Recebe mensagem", description = "insere mensagem no tópico")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna mensagem no tópico"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    @PostMapping("/enviar-mensagem")
    public void enviarmensagem(String mensagem){
        produtorService.enviarMensagem(mensagem);
    }
}
