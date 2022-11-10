package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokenService {
    @Value("${jwt.secret}")
    private String secret;


    public String getToken(UsuarioEntity usuarioEntity) {

        LocalDateTime dateAtualLocaldate = LocalDateTime.now();
        Date dataAtual = Date.from(dateAtualLocaldate.atZone(ZoneId.systemDefault()).toInstant());

        LocalDateTime dateExpiracaoLocalDate = dateAtualLocaldate.plusMonths(1);
        Date dateExpiracao = Date.from(dateExpiracaoLocalDate.atZone(ZoneId.systemDefault()).toInstant());

        String token = Jwts.builder()
                .setIssuer("vemser-api")
                .claim(Claims.ID, usuarioEntity.getIdUsuario().toString())
                .claim("teste", "@gitsplit12")
                .setIssuedAt(dataAtual)
                .setExpiration(dateExpiracao)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
        return token;

        // String tokentexto = usuarioEntity.getLogin() + ";" + usuarioEntity.getSenha();
        // String token = Base64.getEncoder().encodeToString(tokentexto.getBytes());
        //return token;
    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        if (token == null) {
            return null;
        }

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
