import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContaTest {
    private ContaCorrente contaCorrente;
    private Contapoupanca contaPoupanca;
    private ContaPagamento contaPagamento;

    private Contapoupanca jhennyContaPoupanca;


    @BeforeEach
    public void init() {
        jhennyContaPoupanca = new Contapoupanca();
        contaCorrente = new ContaCorrente();
        contaPoupanca = new Contapoupanca();
        contaPagamento = new ContaPagamento();
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo() {
        //contaCorrente.setSaldo(1500);
        //contaCorrente.setChequeEspecial(200);
        double valorSaque = 0;

        boolean testeSaque = contaCorrente.sacar(valorSaque);

        assertTrue(testeSaque);
    }

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        contaPoupanca.setSaldo(1500);
        double valorSaque = 1200;

        boolean testeSaque = contaPoupanca.sacar(valorSaque);

        assertTrue(testeSaque);

    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo() {
        double valorSaque = 0;

        boolean testeSaque = contaPoupanca.sacar(valorSaque);

        assertTrue(testeSaque);
    }

    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso() {
        contaPagamento.setSaldo(500);
        double valorSaque = 100;

        boolean testeSaque = contaPagamento.sacar(valorSaque);

        assertTrue(testeSaque);
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo() {
        double valorSaque = 0;

        boolean testeSaque = contaPagamento.sacar(valorSaque);

        assertTrue(testeSaque);
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso() {
        contaCorrente.setSaldo(900);
        jhennyContaPoupanca.setSaldo(120);
        contaCorrente.setChequeEspecial(150);
        double contaPoupancaSaldo = jhennyContaPoupanca.getSaldo();
        double valorTrasferencia = 120;

        boolean testeTransferencia = contaCorrente.transferir(jhennyContaPoupanca, valorTrasferencia);

        assertTrue(testeTransferencia);
        System.out.println();
    }

}
