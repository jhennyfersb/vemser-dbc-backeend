import java.text.DecimalFormat;

public class ContaCorrente extends Conta implements Impressao {
    private double chequeEspecial;

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public boolean sacar(double saldoSacar) {
        if (getSaldo() + chequeEspecial >= saldoSacar) {
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

    public double retornarSaldoComChequeEspecial() {
        return this.getSaldo() + getChequeEspecial();
    }


    @Override
    public void imprimir() {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        System.out.println("Cliente : " + getCliente().getNome() +
                "\nNumero da Conta : " + getNumeroConta() +
                "\nAgência : " + getAgencia() +
                "\nSaldo : " + getSaldo() +
                df.format(getSaldo()) +
                "\nCheque Especial : " +
                df.format(chequeEspecial) +
                "\n-------------------------------------");
    }

}
