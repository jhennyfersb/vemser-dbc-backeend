package exercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor de a");

        int a = sc.nextInt();
        System.out.println("Digite o valor de b");

        int b = sc.nextInt();
        int troca = a;

        a = b;
        b = troca;

        System.out.println("a = " + a + " b = " + b);

    }
}
