package br.com.dbc.vemser.pessoaapi.security;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
        UsernamePasswordAuthenticationToken user = tokenService.isValid(headerAuthorization);//valida se ususario esta autenticado
        SecurityContextHolder.getContext().setAuthentication(user);
        filterChain.doFilter(request, response);
    }
}
