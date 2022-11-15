package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.dto.UsuarioCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.UsuarioDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.security.TokenService;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioService usuarioService;

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;


    @PostMapping//fazer na service essa logica trabalho final//string token de acesso
    public String auth(@RequestBody @Valid LoginDTO logintDTO)  {
        //criar objeto UsernamePasswordAuthenticationToken com o usuário e senha
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(logintDTO.getLogin(), logintDTO.getSenha());

        // utilizar AuthenticationManager para se autenticar
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //recuperar usuário após da autenticação (getPrincipal()) usuario logado//UsuarioEntity
        Object principal = authenticate.getPrincipal();
        UsuarioEntity usuarioEntity = (UsuarioEntity) principal;//

        //GERAR TOKEN (usuarioEntity da autenticação)
        String token = tokenService.getToken(usuarioEntity);
        return token;
    }
    @PostMapping("/create")
    public UsuarioDTO create(@RequestBody @Valid UsuarioCreateDTO usuarioCreateDTO){
        UsuarioDTO usuarioDTO= usuarioService.create(usuarioCreateDTO);
        return usuarioDTO;
    }
    @GetMapping
    public UsuarioDTO retornaUsuarioLogado() throws RegraDeNegocioException {
        return usuarioService.getLoggedUser();
    }
}
