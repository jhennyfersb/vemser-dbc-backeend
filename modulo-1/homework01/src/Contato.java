public class Contato {
    String descricao;
    String telefone;
    TipoContato tipoContato;

    public Contato(String descricao, String telefone, TipoContato tipoContato) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipoContato = tipoContato;
    }
    public void imprimirContato() {
        System.out.println("Descrição : " + descricao + "\nTelefone : " + telefone + "\nTipo de Contatp : " + tipoContato);
    }
}
