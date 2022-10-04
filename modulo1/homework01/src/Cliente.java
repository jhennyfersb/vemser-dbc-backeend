import java.util.Arrays;

public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public Cliente(String nome,
                   String cpf,
                   Contato[] contato,
                   Endereco[] endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contato;
        this.enderecos = endereco;
    }

    public void imprimirContatos() {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] != null) {
            System.out.println("Tipo de Contato : " + contatos[i].tipoContato);
            System.out.println("Descrição : " + contatos[i].descricao);
            System.out.println("Telefone : " + contatos[i].telefone);
           }
        }
    }

    public void imprimirEnderecos() {

        for (int i = 0; i < enderecos.length; i++) {
            System.out.println("Tipo de Endereço : " + enderecos[i].tipoEndereco + "\n Logradouro : " + enderecos[i].logradouro + "\n Numero : " + enderecos[i].numero + "\nComplemento : " + enderecos[i].complemento +
                    "\n Cep : " + enderecos[i].cep + "\n Estado : " + enderecos[i].estado + "\nPais : " + enderecos[i].pais);

        }
    }

    public void imprimirCliente() {
        System.out.println(nome + cpf);
    }
}
