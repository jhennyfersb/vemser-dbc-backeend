public class Endereco {
    TipoEndereco tipoEndereco;
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String estado;
    String pais;

    public Endereco(TipoEndereco tipoEndereco,
                    String logradouro,
                    int numero,
                    String complemento,
                    String cep,
                    String estado,
                    String pais) {
        this.tipoEndereco = tipoEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.estado = estado;
        this.pais = pais;
    }

    public void imprimirEndereco() {
        System.out.println("Tipo de Endereço : " + tipoEndereco + "\n Logradouro : " + logradouro + "\n Numero : " + numero + "\nComplemento : " + complemento +
                "\n Cep : " + cep + "\n Estado : " + estado + "\nPais : " + pais);
    }
}
