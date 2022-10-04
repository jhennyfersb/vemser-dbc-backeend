public class Contato {
    private String descricao;
    private String telefone;
    private TipoContato tipoContato;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(TipoContato tipoContato) {
        this.tipoContato = tipoContato;
    }

    public Contato(String descricao, String telefone, TipoContato tipoContato) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipoContato = tipoContato;
    }

    public void imprimirContato() {
        System.out.println("Descrição : " + descricao +
                "\nTelefone : " + telefone +
                "\nTipo de Contatp : " + tipoContato);
    }
}
