package exercicio8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] vetor = new int[]{8,7,5,4,2,1,6,9,0,10};
        System.out.println("Digite um numero");
        int numeroUsuario = sc.nextInt();
        int contVezes = 0;
        int contNumMenor = 0;
        int contNumMarior = 0;

        for (int j : vetor) {
            if (numeroUsuario == j) {
                contVezes++;
            } else if (numeroUsuario > j) {
                contNumMenor++;
            } else {
                contNumMarior++;
            }
        }

        System.out.println("Tem " + contVezes +" numeros igual ao numero digitado");
        System.out.println("Tem " + contNumMenor + " numeros menores que o valor digitado");
        System.out.println("Tem " + contNumMarior + " numeros maiores que o valor digitado");
    }
}
