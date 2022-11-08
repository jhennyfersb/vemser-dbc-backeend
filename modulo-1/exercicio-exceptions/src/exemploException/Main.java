package exemploException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            dividir(sc.nextInt(), sc.nextInt());

        } catch (InputMismatchException mismatchException) {
            mismatchException.printStackTrace();
            System.out.println("Você digitou valores não númericos, repita a operação");
            dividir(sc.nextInt(), sc.nextInt());

        } catch (DivideByZeroException exception) {
            System.out.println(exception.getMessage());
            dividir(sc.nextInt(), sc.nextInt());

        } finally {
            sc.close();
        }
    }

    public static void dividir(int a, int b) {
        if (b == 0) throw new DivideByZeroException();
        int divisao = a / b;
        System.out.println("Operação realizada com sucesso!");
    }
}

