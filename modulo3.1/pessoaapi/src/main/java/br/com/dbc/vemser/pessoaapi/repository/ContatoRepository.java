package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.entity.TipoContato;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ContatoRepository {
    private static List<Contato> listaContatos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public ContatoRepository() {
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 1, TipoContato.RESIDENCIAL, "48991172345", "telefone"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 2, TipoContato.RESIDENCIAL, "48990234567", "telefone"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 3, TipoContato.RESIDENCIAL, "4691209384", "whatsApp"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 4, TipoContato.RESIDENCIAL, "9299991876", "telefone"));
        listaContatos.add(new Contato(COUNTER.incrementAndGet(), 5, TipoContato.RESIDENCIAL, "92991180191", "whastsApp"));
    }

    public Contato create(Contato contato) {
        contato.setIdContato(COUNTER.incrementAndGet());
        listaContatos.add(contato);
        return contato;
    }

    public List<Contato> list() {
        return listaContatos;
    }

    public Contato update(Integer id, Contato contatoAtualizar) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws Exception {
        Contato contatoRecuperado = listaContatos.stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Contato não encontrado"));
        listaContatos.remove(contatoRecuperado);
    }

    public List<Contato> listByNumber(String numero) {
        return listaContatos.stream()
                .filter(contato -> contato.getNumero().toUpperCase().contains(numero.toUpperCase()))
                .collect(Collectors.toList());
    }
    public Contato buscarPorId(Integer idPessoa){
       return listaContatos.stream().filter(contato -> Objects.equals(contato.getIdPessoa(), idPessoa)).findFirst().get();

    }
}
