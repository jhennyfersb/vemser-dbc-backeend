package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.dto.UsuarioCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.UsuarioDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.security.TokenService;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {
    private final UsuarioService usuarioService;

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;


    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO logintDTO)  {
        //FIXME criar objeto UsernamePasswordAuthenticationToken com o usuário e senha
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(logintDTO.getLogin(), logintDTO.getSenha());

        //FIXME utilizar AuthenticationManager para se autenticar
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //FIXME recuperar usuário após da autenticação (getPrincipal())
        Object principal = authenticate.getPrincipal();
        UsuarioEntity usuarioEntity = (UsuarioEntity) principal;

        //FIXME GERAR TOKEN (usuarioEntity da autenticação)
        String token = tokenService.getToken(usuarioEntity);
        return token;
    }
    @PostMapping("/create")
    public UsuarioDTO create(@RequestBody @Valid UsuarioCreateDTO usuarioCreateDTO){
        UsuarioDTO usuarioDTO= usuarioService.create(usuarioCreateDTO);
        return usuarioDTO;
    }
}
