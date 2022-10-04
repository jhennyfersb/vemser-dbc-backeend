public interface Movimentacao {
    boolean sacar(double saldoSacar);
    boolean depositar(double saldoDepositar);
    boolean transferir(Conta conta, double valor);
}
