package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private String expiration;

    public String getToken(UsuarioEntity usuarioEntity) {

        LocalDateTime dateAtualLocaldate = LocalDateTime.now();
        Date dataAtual = Date.from(dateAtualLocaldate.atZone(ZoneId.systemDefault()).toInstant());

        LocalDateTime dateExpiracaoLocalDate = dateAtualLocaldate.plusDays(Long.parseLong(expiration));
        Date dateExpiracao = Date.from(dateExpiracaoLocalDate.atZone(ZoneId.systemDefault()).toInstant());

        // gerar token jwt
        String token = Jwts.builder()
                .setIssuer("vemser-api")
                .claim(Claims.ID, usuarioEntity.getIdUsuario().toString())
                .setIssuedAt(dataAtual)
                .setExpiration(dateExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return token;

    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        if (token == null) {
            return null;
        }
        // verificar se o usuário é válido pelo token JWT e recuperar o usuário e retornar

        token = token.replace("Bearer ", "");

        Claims chaves = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        String idUsuario = chaves.get(Claims.ID,String.class);

        UsernamePasswordAuthenticationToken dtoSpringToken =
                new UsernamePasswordAuthenticationToken(idUsuario,
                        null,
                        Collections.emptyList());

        return dtoSpringToken;
    }
}
