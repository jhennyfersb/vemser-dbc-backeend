public interface Movimentacao {
    boolean sacar(double valorSacar);
    boolean depositar(double valorDepositar);
    boolean transferir(Conta conta, double valor);
}
