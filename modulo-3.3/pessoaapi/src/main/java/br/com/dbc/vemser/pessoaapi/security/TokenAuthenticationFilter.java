package br.com.dbc.vemser.pessoaapi.security;


import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;


public class TokenAuthenticationFilter extends OncePerRequestFilter {
    private final TokenService tokenService;

    public TokenAuthenticationFilter(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
        String headerAuthorization = request.getHeader("Authorization");
        Optional<UsuarioEntity> isValid = tokenService.isValid(headerAuthorization);

        if (isValid.isPresent()) {
        UsuarioEntity usuarioEntity = isValid.get();
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(usuarioEntity.getLogin(),usuarioEntity.getSenha(), Collections.emptyList());
            SecurityContextHolder.getContext().setAuthentication(token);
        } else {
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        filterChain.doFilter(request, response);
    }
}
