package exercicio6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o numero total de votos dos eleitores?");
        int numTotalEleitores = sc.nextInt();

        System.out.println("Qual o numero  votos  brancos?");
        int numVotosBrancos = sc.nextInt() * 100;

        System.out.println("Qual o numero  votos  nulos");
        int numVotosNulos = sc.nextInt() * 100;

        System.out.println("Qual o numero  votos  validos");
        int numVotosValidos = sc.nextInt() * 100;

        int porcVotosBrancos = numVotosBrancos / numTotalEleitores;
        int porcVotosNulos = numVotosNulos / numTotalEleitores;
        int porcVotosValidos = numVotosValidos / numTotalEleitores;

        System.out.println("Percentual Votos brancos é " + porcVotosBrancos + "%" + " Percentual Votos nulos é " + porcVotosNulos + "%" + " Percentual Votos válidos é " + porcVotosValidos + "%");



    }
}
