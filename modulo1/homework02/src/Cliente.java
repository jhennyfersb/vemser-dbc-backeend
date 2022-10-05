public class Cliente {
    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

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
    public Contato[] getContatos() {
        return contatos;
    }
    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }
    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecos) {
        this.enderecos = enderecos;
    }

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
        if(contatos != null) {
            for (Contato contato : contatos) {
                if (contato != null) {
                    System.out.println("Nome do Contato :" + getNome());
                    System.out.println("Tipo de Contato : " + contato.getTipoContato());
                    System.out.println("Descrição : " + contato.getDescricao());
                    System.out.println("Telefone : " + contato.getTelefone());
                    System.out.println("-------------------------------------");
                }
            }
        }
    }
    public void imprimirEnderecos() {
        if(contatos != null) {
            for (int i = 0; i < enderecos.length; i++) {
                if(enderecos[i] != null) {
                    System.out.println("Nome do Cliente : " +
                            getNome() + "\nTipo de Endereço : " +
                            enderecos[i].getTipoEndereco() + "\nLogradouro : " +
                            enderecos[i].getLogradouro() + "\nNumero : " +
                            enderecos[i].getNumero() + "\nComplemento : " +
                            enderecos[i].getComplemento() +
                            "\nCep : " + enderecos[i].getCep() +
                            "\nEstado : " + enderecos[i].getEstado() +
                            "\nPais : " + enderecos[i].getPais() +
                            "\n-------------------------------------");
                }
            }
        }
    }

    public void imprimirCliente() {
        System.out.println("Nome Cliente : "+getNome() +
                "\nNome cpf : "+getCpf());
    }


}
