package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.dto.LoginDTO;
import br.com.dbc.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.dbc.vemser.pessoaapi.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
   private final UsuarioRepository usuarioRepository;
   private final ObjectMapper objectMapper;

   public Optional<UsuarioEntity> findByLoginAndSenha(String login, String senha){
       return usuarioRepository.findByLoginAndSenha(login, senha);
   }
}