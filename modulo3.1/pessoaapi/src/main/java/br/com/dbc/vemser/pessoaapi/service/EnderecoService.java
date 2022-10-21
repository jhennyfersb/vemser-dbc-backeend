package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    private EnderecoRepository enderecoRepository;
    private PessoaService pessoaService;

    public EnderecoService(EnderecoRepository enderecoRepository, PessoaService pessoaService){
        this.enderecoRepository = enderecoRepository;
        this.pessoaService = pessoaService;
    }

    public Endereco create(Endereco endereco)throws RegraDeNegocioException{
        pessoaService.findById(endereco.getIdPessoa());
        return enderecoRepository.create(endereco);
    }
    public List<Endereco> list(){
        return enderecoRepository.list();
    }
    public Endereco findById(Integer idEndereco)throws RegraDeNegocioException{
        Endereco enderecoRecuperado = enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(idEndereco))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));

        return enderecoRecuperado;
    }
    public Endereco update(Integer id,Endereco enderecoAtualizar) throws RegraDeNegocioException {
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

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco enderecoDeletado = findById(id);
        enderecoRepository.delete(enderecoDeletado);
    }
    public List<Endereco> buscarPorId(String pessoaId){
        return enderecoRepository.buscarPorId(Integer.parseInt(pessoaId));
    }

}
