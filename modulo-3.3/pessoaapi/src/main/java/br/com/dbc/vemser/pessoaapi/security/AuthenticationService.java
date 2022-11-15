package br.com.dbc.vemser.pessoaapi.security;

import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {
    private final UsuarioService usuarioService;
    @Override
    public UserDetails loadUserByUsername(String loginUsuario) throws UsernameNotFoundException {
        // buscar usuário pelo login
        Optional<UsuarioEntity> optionalUsuario = usuarioService.findByLogin(loginUsuario);
        return optionalUsuario
                .orElseThrow(() -> new UsernameNotFoundException("Usuário inválido"));
    }

}
