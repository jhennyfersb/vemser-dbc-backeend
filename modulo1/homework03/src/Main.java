import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Endereco enderecoJhennyfer = new Endereco(TipoEndereco.RESIDENCIAL, "Avenida Brasil", 872,
                "Monte Carmelo", "85501057", "Paraná", "Brasil");
        Contato contatoJhennyfer = new Contato("celular", "46991180191", TipoContato.RESIDENCIAL);
        ArrayList<Contato> contatosJhennyfer = new ArrayList<>();
        contatosJhennyfer.add(contatoJhennyfer);
        ArrayList<Endereco> enderecosJhennyfer = new ArrayList<>();
        enderecosJhennyfer.add(enderecoJhennyfer);
        Cliente clienteJhennyfer = new Cliente("Jhennyfer Silva Sobrinho", "056872651-04",
                contatosJhennyfer, enderecosJhennyfer);
        ContaPagamento contaPagamentoJhennyfer = new ContaPagamento(clienteJhennyfer, "1236", "0987", 500.00);
        ContaCorrente contaCorrenteJhennyfer = new ContaCorrente(clienteJhennyfer, "1235", "0987", 1000.00);

        Endereco enderecoMaria = new Endereco(TipoEndereco.RESIDENCIAL, "Lourival Coimbra", 442,
                "antiga s1", "69314540", "Roraima", "Brasil");
        Contato contatoMaria = new Contato("celular", "95992245107", TipoContato.RESIDENCIAL);
        ArrayList<Contato> contatosMaria = new ArrayList<>();
        contatosMaria.add(contatoMaria);
        ArrayList<Endereco> enderecosMaria = new ArrayList<>() {};
        enderecosMaria.add(enderecoMaria);
        Cliente clienteMaria = new Cliente("Maria Fernandes de Lima", "85568901833",
                contatosMaria, enderecosMaria);
        Contapoupanca contapoupancaMaria = new Contapoupanca(clienteMaria, "1235", "9876", 200.00);


        Endereco enderecoCassia = new Endereco(TipoEndereco.RESIDENCIAL, "Lourival Coimbra",
                442, "antiga s1", "69314540", "Roraima", "Brasil");
        Contato contatoCassia = new Contato("celular", "95998523765", TipoContato.RESIDENCIAL);
        ArrayList<Contato> contatosCassia = new ArrayList<>();
        contatosCassia.add(contatoCassia);
        ArrayList<Endereco> enderecosCassia = new ArrayList<>();
        enderecosCassia.add(enderecoCassia);
        Cliente clienteCassia = new Cliente("Cassia Fernandes Sobrinho", "69236701723", contatosCassia, enderecosCassia);
        ContaCorrente contaCorrenteCassia = new ContaCorrente(clienteCassia, "7654", "1230", 500.00);


        contaCorrenteJhennyfer.depositar(500.00);
        contaCorrenteJhennyfer.sacar(200.00);
        contaCorrenteJhennyfer.transferir(contapoupancaMaria, 350.00);
        contaPagamentoJhennyfer.sacar(100.00);
        contapoupancaMaria.transferir(contaCorrenteCassia, 200);
        contaCorrenteJhennyfer.setChequeEspecial(100.00);
        contapoupancaMaria.creditarTaxa();

        contaCorrenteJhennyfer.imprimir();
        contaPagamentoJhennyfer.imprimir();
        contaPagamentoJhennyfer.transferir(contaCorrenteCassia, 60.00);
        contapoupancaMaria.imprimir();
        contaCorrenteCassia.imprimir();

        clienteJhennyfer.imprimirEnderecos();
        clienteJhennyfer.imprimirContatos();

    }
}
