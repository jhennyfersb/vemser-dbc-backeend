import java.text.DecimalFormat;

public class Contapoupanca extends Conta implements Impressao {
    static final double JUROS_MENSAL = 1.01;

    public Contapoupanca(Cliente cliente, String numeroConta, String agencia, double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa() {
        super.setSaldo(getSaldo() * JUROS_MENSAL);
    }

    @Override
    public void imprimir() {
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("R$ #,##0.00");
        System.out.println("Conta Poupança :" +
                "\nCliente : " + getCliente().getNome() +
                "\nNumero da Conta : " + getNumeroConta() +
                "\nAgência : " + getAgencia() +
                "\nSaldo : " + df.format(getSaldo()) +
                "\nJuros Mensal : " + df.format(JUROS_MENSAL)
                + "\n-------------------------------------");
    }
}
