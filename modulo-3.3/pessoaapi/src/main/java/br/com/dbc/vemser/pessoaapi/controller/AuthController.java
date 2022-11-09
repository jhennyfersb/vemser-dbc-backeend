package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.security.TokenService;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioService usuarioService;

    private final TokenService tokenService;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO logintDTO) throws RegraDeNegocioException {
        Optional<UsuarioEntity> byLoginAndSenha =
                usuarioService
                        .findByLoginAndSenha(logintDTO.getLogin(), logintDTO.getSenha());

        if (byLoginAndSenha.isPresent()) {
            return tokenService.getToken(byLoginAndSenha.get());
        }
        throw new RegraDeNegocioException("Usuário e senha inválidos!");
    }
}
