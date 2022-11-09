package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    private final UsuarioService usuarioService;
    public String getToken(UsuarioEntity usuarioEntity) {
        String tokentexto = usuarioEntity.getLogin() + ";" + usuarioEntity.getSenha();
        String token = Base64.getEncoder().encodeToString(tokentexto.getBytes());
        return token;
    }

    public Optional<UsuarioEntity> isValid(String token) {
        if (token == null){
            return Optional.empty();
        }
        token = token.replace("Bearer ","");
        byte[] decode = Base64.getUrlDecoder().decode(token);
        String decoded = new String(decode);
        String[] split = decoded.split(";");
        return usuarioService.findByLoginAndSenha(split[0],split[1]);
    }
}
