package dbc.company.produtoconsumidor.controller;

import dbc.company.produtoconsumidor.service.ProdutorService;
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

    @PostMapping("/enviar-mensagem")
    public void enviarmensagem(String mensagem){
        produtorService.enviarMensagem(mensagem);
    }
}
