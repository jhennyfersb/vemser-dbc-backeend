package br.com.dbc.vemser.pessoaapi.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeradorDeSenhas {

    public static void main(String[] args) {
        //exemplo de geração de senha
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //String senha = bCryptPasswordEncoder.encode("123");
        //String senhaCriptografada = "senhacriptografada";
        //boolean verificacaoSenhas = bCryptPasswordEncoder.matches("123",senhaCriptografada); retorna true

    }
}
