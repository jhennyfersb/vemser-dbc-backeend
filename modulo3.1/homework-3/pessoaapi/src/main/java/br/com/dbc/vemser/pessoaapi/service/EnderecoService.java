package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository){
        this.enderecoRepository = enderecoRepository;
    }

    public Endereco create(Endereco endereco){
        return enderecoRepository.create(endereco);
    }
    public List<Endereco> list(){
        return enderecoRepository.list();
    }
    public Endereco findById(Integer idEndereco)throws Exception{
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new Exception("Endereço não encontrado"));

        return enderecoRecuperado;
    }
    public Endereco update(Integer id,Endereco enderecoAtualizar) throws Exception {
        Endereco enderecoRecuperado = findById(id);

        enderecoRecuperado.setTipo(enderecoAtualizar.getTipo());
        enderecoRecuperado.setLogradouro(enderecoAtualizar.getLogradouro());
        enderecoRecuperado.setComplemento(enderecoAtualizar.getComplemento());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setCep(enderecoAtualizar.getCep());
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setPais(enderecoAtualizar.getPais());
        return enderecoRecuperado;
    }
    public List<Endereco> listByEndereco(Integer id){
        return enderecoRepository.listByEndereco(id);
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoDeletado = findById(id);
        enderecoRepository.delete(enderecoDeletado);
    }
    public List<Endereco> buscarPorId(String pessoaId){
        return enderecoRepository.buscarPorId(Integer.parseInt(pessoaId));
    }

}
