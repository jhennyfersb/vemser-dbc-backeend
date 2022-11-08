package exercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[20];

        for (int i = 0; i < 20; i++) {
            System.out.println("Digite um numero");
            numeros[i] = sc.nextInt();
        }
        System.out.println("Seus numeros em ordem contrária à que foram digitados são:");
        for (int j = numeros.length - 1; j >= 0; j--) {
            if (j == numeros.length - 1) {
                System.out.print(numeros[j]);
            } else {
                System.out.print(" " + numeros[j]);
            }
        }
    }
}
