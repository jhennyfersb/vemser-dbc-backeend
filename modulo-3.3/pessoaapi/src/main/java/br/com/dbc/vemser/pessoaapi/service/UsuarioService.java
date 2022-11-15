package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.UsuarioCreateDTO;
import br.com.dbc.vemser.pessoaapi.dto.UsuarioDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder encoder;

    public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha) {
        return usuarioRepository.findByLoginAndSenha(login, senha);
    }

    // public Optional<UsuarioEntity> findById(Integer idUsuario) {
    //     return usuarioRepository.findById(idUsuario);
    // }

    public Optional<UsuarioEntity> findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    public UsuarioDTO create(UsuarioCreateDTO usuarioCreateDTO) {
        UsuarioEntity usuarioEntity = objectMapper.convertValue(usuarioCreateDTO, UsuarioEntity.class);
        String encode = encoder.encode(usuarioEntity.getPassword());
        usuarioEntity.setSenha(encode);
        UsuarioEntity usuario = usuarioRepository.save(usuarioEntity);
        return objectMapper.convertValue(usuario, UsuarioDTO.class);
    }

    public UsuarioDTO getLoggedUser() throws RegraDeNegocioException {
        UsuarioEntity usuarioEntity = findById(getIDLoggedUser());
        return objectMapper.convertValue(usuarioEntity, UsuarioDTO.class);
    }

    public Integer getIDLoggedUser() {
        return Integer.parseInt((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    public UsuarioEntity findById(Integer idUsuario) throws RegraDeNegocioException {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() ->
                        new RegraDeNegocioException("Usuário não encontrado!"));

    }
}