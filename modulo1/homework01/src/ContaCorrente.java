import java.text.DecimalFormat;

public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia = 1243;
    double saldo;
    double chequeEspecial;


    public ContaCorrente(Cliente cliente,
                         double saldo,
                         double chequeEspecial) {
        this.cliente = cliente;
        this.numeroConta = String.valueOf(SEQUENCIAL++);
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
    }

    public void imprimirContaCorrente() {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        System.out.println("Cliente : " + cliente.nome + "\nNumero da Conta : " + numeroConta + "\nAgência : " +
                agencia + "\nSaldo : " + df.format(saldo) + "\nCheque Especial : " + df.format(chequeEspecial) + "\n----------------");
    }

    public boolean sacar(double saldoSacar) {
        if (this.saldo + chequeEspecial > saldoSacar) {
            this.saldo -= saldoSacar;
            return true;
        }
        return false;
    }

    public boolean depositar(double saldo) {
        this.saldo += saldo;
        return true;
    }

    public double retornarSaldoComChequeEspecial() {
        return this.saldo + chequeEspecial;
    }

    public boolean transferir(ContaCorrente contaCorrente, double valor) {
        if (sacar(valor)) {
            contaCorrente.depositar(valor);
            return true;
        }
        return false;
    }

    private static int SEQUENCIAL = 1;
}
