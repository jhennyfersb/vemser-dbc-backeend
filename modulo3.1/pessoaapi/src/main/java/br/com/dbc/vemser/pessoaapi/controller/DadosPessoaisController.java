package br.com.dbc.vemser.pessoaapi.controller;

import br.com.dbc.vemser.pessoaapi.client.DadosPessoaisClient;
import br.com.dbc.vemser.pessoaapi.dto.DadosPessoaisDTO;
import feign.Param;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dados-pessoais")
public class DadosPessoaisController {
    private final DadosPessoaisClient dadosPessoaisClient;

    @GetMapping
    public List<DadosPessoaisDTO> listDadosPessoais() {
        return dadosPessoaisClient.getAll();
    }

    @GetMapping("/{cpf}")
    public DadosPessoaisDTO getByCpf(@PathVariable("cpf") String cpf) {
        return dadosPessoaisClient.get(cpf);
    }

    @PostMapping
    public DadosPessoaisDTO create(@RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.post(dadosPessoaisDTO);
    }

    @PutMapping("/{cpf}")
    public DadosPessoaisDTO put(@PathVariable("cpf") String cpf,
                                @RequestBody DadosPessoaisDTO dadosPessoaisDTO) {
        return dadosPessoaisClient.put(cpf, dadosPessoaisDTO);
    }

    @DeleteMapping("/{cpf}")
    public void delete(@PathVariable("cpf") String cpf) {
        dadosPessoaisClient.delete(cpf);
    }

}
