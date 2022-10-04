public class Main {
    public static void main(String[] args) {
        Endereco enderecoJhennyfer = new Endereco(TipoEndereco.RESIDENCIAL, "Avenida Brasil", 872,
                "Monte Carmelo", "85501057", "Paraná", "Brasil");
        Contato contatoJhennyfer = new Contato("celular", "46991180191", TipoContato.RESIDENCIAL);
        Cliente clienteJhennyfer = new Cliente("Jhennyfer Silva Sobrinho", "056872651-04",
                new Contato[]{contatoJhennyfer}, new Endereco[]{enderecoJhennyfer});
        ContaCorrente contaCorrenteJhennyfer = new ContaCorrente(clienteJhennyfer, "1235", "0987", 1000.00);
        Contapoupanca contaPoupancaJhennyfer = new Contapoupanca(clienteJhennyfer, "0152", "0987", 250.00);

        Endereco enderecoMaria = new Endereco(TipoEndereco.RESIDENCIAL, "Lourival Coimbra", 442,
                "antiga s1", "69314540", "Roraima", "Brasil");
        Contato contatoMaria = new Contato("celular", "95992245107", TipoContato.RESIDENCIAL);
        Cliente clienteMaria = new Cliente("Maria Fernandes de Lima", "85568901833",
                new Contato[]{contatoMaria}, new Endereco[]{enderecoMaria});
        ContaCorrente contaCorrenteMaria = new ContaCorrente(clienteMaria, "1235", "9876", 200.00);

        Endereco enderecoCassia = new Endereco(TipoEndereco.RESIDENCIAL, "Lourival Coimbra",
                442, "antiga s1", "69314540", "Roraima", "Brasil");
        Contato contatoCassia = new Contato("celular", "95998523765", TipoContato.RESIDENCIAL);
        Cliente clienteCassia = new Cliente("Cassia Fernandes Sobrinho", "69236701723", new Contato[]{contatoCassia}, new Endereco[]{enderecoCassia});
        ContaCorrente contaCorrenteCassia = new ContaCorrente(clienteCassia, "7654", "1230", 500.00);


        contaCorrenteJhennyfer.depositar(500.00);
        contaCorrenteJhennyfer.sacar(200.00);
        contaCorrenteJhennyfer.transferir(contaCorrenteMaria, 350.00);
        contaCorrenteMaria.transferir(contaCorrenteCassia, 200);
        contaCorrenteJhennyfer.setChequeEspecial(100.00);
        contaPoupancaJhennyfer.creditarTaxa();
        contaCorrenteJhennyfer.imprimir();
        contaPoupancaJhennyfer.imprimir();

        contaCorrenteMaria.imprimir();
        contaCorrenteCassia.imprimir();


        clienteJhennyfer.imprimirEnderecos();
        clienteJhennyfer.imprimirContatos();

    }
}
