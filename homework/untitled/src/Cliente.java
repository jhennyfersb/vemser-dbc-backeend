import java.util.Arrays;

public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos;
    Endereco[] enderecos;

    public Cliente(String nome,
                   String cpf,
                   Contato[] contatos,
                   Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void imprimirContatos() {
        System.out.println(Arrays.toString(contatos));
    }

    public void imprimirEnderecos() {
        System.out.println(Arrays.toString(enderecos));
    }

    public void imprimirCliente() {
        System.out.println(nome + cpf);
    }
}
