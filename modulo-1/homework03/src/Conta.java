abstract public class Conta implements Movimentacao {
    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private double saldo;

    public Conta() {

    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public Conta(Cliente cliente, String numeroConta, String agencia, double saldo) {
        this.cliente = cliente;
        this.numeroConta = String.valueOf(SEQUENCIAL++);
        this.agencia = agencia;
        this.saldo = saldo;
    }
    @Override
    public boolean sacar(double valorSacar) {
        if (getSaldo() >= valorSacar) {
            saldo -= valorSacar;
            return true;
        }
        return false;
    }
    @Override
    public boolean depositar(double valorDepositar) {
        if (valorDepositar > 0) {
            saldo += valorDepositar;
            return true;
        }
        return false;
    }
    @Override
    public boolean transferir(Conta conta, double valorTransferir) {
        if (sacar(valorTransferir)) {
            conta.depositar(valorTransferir);
            return true;
        }
        return false;
    }
    private static int SEQUENCIAL = 2345;
}
