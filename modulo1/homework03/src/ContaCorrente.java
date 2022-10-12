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
        setChequeEspecial(chequeEspecial);
    }

    public ContaCorrente() {
    }

    public double retornarSaldoComChequeEspecial() {
        return this.getSaldo() + getChequeEspecial();
    }

    @Override
    public boolean sacar(double valorSacar) {
        if (getSaldo() + chequeEspecial >= valorSacar) {
            super.setSaldo(getSaldo() - valorSacar);
            return true;
        }
        return false;
    }

    @Override
    public void imprimir() {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        System.out.println("Conta Corrente :" +
                "\nCliente : " + getCliente().getNome() +
                "\nNumero da Conta : " + getNumeroConta() +
                "\nAgência : " + getAgencia() +
                "\nSaldo : " + df.format(getSaldo()) +
                "\nCheque Especial : " +
                df.format(chequeEspecial) +
                "\n-------------------------------------");
    }
}
