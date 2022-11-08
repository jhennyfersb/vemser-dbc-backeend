package exercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 10;
        int b = 20;
        int troca = a;

        a = b;
        b = troca;
        System.out.println("a = " + a + " b = " + b);

    }
}
