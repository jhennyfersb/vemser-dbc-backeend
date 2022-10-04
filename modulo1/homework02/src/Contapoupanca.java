import java.text.DecimalFormat;

public class Contapoupanca extends Conta implements Impressao {
    static final double JUROS_MENSAL = 1.01;

    public void creditarTaxa() {
        super.setSaldo(getSaldo() * JUROS_MENSAL);
    }

    public Contapoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }
    @Override
    public boolean sacar(double saldoSacar) {
        if (getSaldo()  >= saldoSacar) {
            super.setSaldo(getSaldo() - saldoSacar);
            return true;
        }
        return false;
    }
    @Override
    public boolean depositar(double saldoDepositar) {
        if (saldoDepositar > 0) {
            super.setSaldo(getSaldo() + saldoDepositar);
            return true;
        }
        return false;
    }

    @Override
    public boolean transferir(Conta conta, double valor) {
        if (sacar(valor)) {
            conta.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public void imprimir() {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        System.out.println("Cliente : " + getCliente().getNome() +
                "\nNumero da Conta : " + getNumeroConta() +
                "\nAgência : " + getAgencia() +
                "\nSaldo : " + getSaldo()  + df.format(getSaldo()) +
                "\nJuros Mensal : " + df.format(JUROS_MENSAL)
                + "\n-------------------------------------");
    }
}
