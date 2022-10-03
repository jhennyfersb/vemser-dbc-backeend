public class Main {
    public static void main(String[] args) {
        Endereco enderecoJhennyfer = new Endereco(TipoEndereco.RESIDENCIAL, "Avenida Brasil", 872, "Monte Carmelo", "85501057", "Paraná", "Brasil");
        Contato contatoJhennyfer = new Contato("celular", "46991180191", TipoContato.RESIDENCIAL);
        Cliente clienteJhennyfer = new Cliente("Jhennyfer Silva Sobrinho",
                "056872651-04", contatoJhennyfer, enderecoJhennyfer);
        ContaCorrente contaCorrenteJhennyfer = new ContaCorrente(clienteJhennyfer, 10000000000.00, 200.00);

        Endereco enderecoMaria = new Endereco(TipoEndereco.RESIDENCIAL, "Lourival Coimbra", 442, "antiga s1", "69314540", "Roraima", "Brasil");
        Contato contatoMaria = new Contato("celular", "95992245107", TipoContato.RESIDENCIAL);
        Cliente clienteMaria = new Cliente("Maria Fernandes de Lima", "85568901833", contatoMaria, enderecoMaria);
        ContaCorrente contaCorrenteMaria = new ContaCorrente(clienteMaria, 100.00, 200.00);

        Endereco enderecoCassia = new Endereco(TipoEndereco.RESIDENCIAL, "Lourival Coimbra", 442, "antiga s1", "69314540", "Roraima", "Brasil");
        Contato contatoCassia = new Contato("celular", "95998523765", TipoContato.RESIDENCIAL);
        Cliente clienteCassia = new Cliente("Cassia Fernandes Sobrinho", "69236701723", contatoCassia, enderecoCassia);
        ContaCorrente contaCorrenteCassia = new ContaCorrente(clienteCassia, 5000.00, 900.00);


        contaCorrenteJhennyfer.depositar(500.00);
        contaCorrenteJhennyfer.sacar(200.00);
        contaCorrenteJhennyfer.transferir(contaCorrenteMaria, 350.00);
        contaCorrenteMaria.transferir(contaCorrenteCassia, 200);

        contaCorrenteJhennyfer.imprimirContaCorrente();
        contaCorrenteCassia.imprimirContaCorrente();
        contaCorrenteMaria.imprimirContaCorrente();

        clienteCassia.imprimirContatos();

    }
}
