public class Endereco {
    private TipoEndereco tipoEndereco;
    private String logradouro;
    private int numero;
    private String complemento;
    private String cep;
    private String estado;
    private String pais;

    public TipoEndereco getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(TipoEndereco tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

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
        System.out.println("Tipo de Endereço : " + tipoEndereco +
                "\n Logradouro : " + logradouro +
                "\n Numero : " + numero +
                "\nComplemento : " + complemento +
                "\n Cep : " + cep +
                "\n Estado : " + estado +
                "\nPais : " + pais);
    }
}
