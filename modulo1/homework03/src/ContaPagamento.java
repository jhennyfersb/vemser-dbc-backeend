import java.text.DecimalFormat;

public class ContaPagamento extends Conta implements Impressao {
    private static final double TAXA_SAQUE = 4.25;
    double saldoAntesDeSacar = getSaldo();

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }
    @Override
    public boolean sacar(double valorSacar) {
        if (getSaldo() >= valorSacar + TAXA_SAQUE) {
            super.setSaldo(getSaldo() - valorSacar - TAXA_SAQUE);
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

    @Override
    public void imprimir() {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        System.out.println("Conta Pagamento :" +
                "\nCliente : " + getCliente().getNome());
        System.out.println("Numero da Conta : " + getNumeroConta() + "\nAgência : " + getAgencia());
        System.out.println("Saldo antes de Sacar : " + df.format(saldoAntesDeSacar));
        System.out.println("Valor do Saque : " + df.format(saldoAntesDeSacar - getSaldo() - TAXA_SAQUE));
        System.out.println("Taxa de saque : " + df.format(TAXA_SAQUE) + "\nSaldo Atual : " + df.format(getSaldo()));
        System.out.println("-------------------------------------");
    }
}
