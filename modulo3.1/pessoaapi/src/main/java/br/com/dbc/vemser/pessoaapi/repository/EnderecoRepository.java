package br.com.dbc.vemser.pessoaapi.repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
@Repository
public class EnderecoRepository {
    private List<Endereco> listaEnderecos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 1,TipoEndereco.RESIDENCIAL,"Av.Brasil",456,"","69314540","Itaituba","Para","Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 2,TipoEndereco.RESIDENCIAL,"LouriVal",62,"","65314545","Pato Branco","Parana","Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 3,TipoEndereco.RESIDENCIAL,"Av.Tupy",872,"","86123094","Boa Vista","Rorarima","Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 4,TipoEndereco.RESIDENCIAL,"São Lucas",56,"","78314549","Beltrão","Parana","Brasil"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(), 5,TipoEndereco.RESIDENCIAL,"Rua Jardim",974,"","56783421","Curitiba","Parana","Brasil"));
    }
    public Endereco create(Endereco endereco){
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }
    public List<Endereco> list(){
        return listaEnderecos;
    }

    public void delete(Endereco endereco){
        listaEnderecos.remove(endereco);
    }
    public List<Endereco> buscarPorId(Integer idPessoa){
        return listaEnderecos.stream().filter(endereco -> endereco.getIdPessoa().equals(idPessoa))
                .collect(Collectors.toList());
    }

    public List<Endereco> listByEndereco(Integer id) {
        return listaEnderecos.stream()
                .filter(endereco1 -> endereco1.getIdEndereco().equals(id))
                .collect(Collectors.toList());
    }
}
