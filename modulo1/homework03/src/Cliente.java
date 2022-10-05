import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos;
    private ArrayList<Endereco> enderecos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public Cliente(String nome, String cpf, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public void imprimirContatos() {
        if (contatos != null) {
            for (Contato contato : contatos) {
                if (contato != null) {
                    System.out.println("Nome do Contato : " + getNome());
                    System.out.println("Tipo de Contato : " + contato.getTipoContato());
                    System.out.println("Descrição : " + contato.getDescricao());
                    System.out.println("Telefone : " + contato.getTelefone());
                    System.out.println("-------------------------------------");
                }
            }
        }
    }

    public void imprimirEnderecos() {
        if (enderecos != null) {
            for (int i = 0; i < enderecos.size(); i++) {
                if (enderecos.get(i) != null) {
                    System.out.println("Nome do Cliente : " +
                            getNome() + "\nTipo de Endereço : " +
                            enderecos.get(i).getTipoEndereco() + "\nLogradouro : " +
                            enderecos.get(i).getLogradouro() + "\nNumero : " +
                            enderecos.get(i).getNumero() + "\nComplemento : " +
                            enderecos.get(i).getComplemento() +
                            "\nCep : " + enderecos.get(i).getCep() +
                            "\nEstado : " + enderecos.get(i).getEstado() +
                            "\nPais : " + enderecos.get(i).getPais() +
                            "\n-------------------------------------");
                }
            }
        }
    }

    public void imprimirCliente() {
        System.out.println("Nome Cliente : " + getNome() +
                "\nNome cpf : " + getCpf());
    }


}
