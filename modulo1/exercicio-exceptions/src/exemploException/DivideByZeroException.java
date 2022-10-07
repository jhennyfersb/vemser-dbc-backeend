package exemploException;

public class DivideByZeroException extends ArithmeticException {
    @Override
    public String getMessage() {
        return "Não é possivel dividir nenhum número por zero, tente novamente ";
    }
}
