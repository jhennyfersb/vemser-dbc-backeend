package exercico2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroASerAdivinhado = sc.nextInt();

        while (true){
            int numeroTentado = sc.nextInt();
            if(numeroTentado == numeroASerAdivinhado){
                System.out.println("Você acertou o numero escolhido");
                break;
            } else if (numeroTentado > numeroASerAdivinhado) {
                System.out.println("O número a ser encontrado é menor do que você digitou ");
            } else {
                System.out.println("O número a ser encontrado é maior do que você digitou.");
            }
        }
    }
}

