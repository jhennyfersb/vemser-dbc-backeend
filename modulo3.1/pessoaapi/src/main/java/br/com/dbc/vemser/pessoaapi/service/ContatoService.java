package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Contato;
import br.com.dbc.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.dbc.vemser.pessoaapi.repository.ContatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {
    private ContatoRepository contatoRepository;
    private PessoaService pessoaService;
    public ContatoService(ContatoRepository contatoRepository, PessoaService pessoaService) {
        this.contatoRepository = contatoRepository;
        this.pessoaService = pessoaService;
    }

    public Contato create(Contato contato) throws RegraDeNegocioException {

            pessoaService.findById(contato.getIdPessoa());

        return contatoRepository.create(contato);
    }

    public List<Contato> list() {
        return contatoRepository.list();
    }

    private Contato findByID(Integer id) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return contatoRecuperado;
    }
    public Contato update(Integer id, Contato contatoAtualizar) throws RegraDeNegocioException {
        Contato contatoRecuperado = findByID(id);
        contatoRecuperado.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperado.setNumero(contatoAtualizar.getNumero());
        contatoRecuperado.setDescricao(contatoAtualizar.getDescricao());
        return contatoRecuperado;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Contato contatoDeletado = findByID(id);
        contatoRepository.delete(contatoDeletado);
    }

    public List<Contato> listByNumber(Integer id) {
        return contatoRepository.listByNumber(id);
    }
    public List<Contato> buscarPorId(Integer pessoaId) {
        return contatoRepository.buscarPorId(pessoaId);
    }
}
