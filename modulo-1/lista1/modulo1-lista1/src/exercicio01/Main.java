package exercicio01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual seu nome?");
        String nomeUsuario = sc.nextLine();

        System.out.println("Quantos anos você tem?");
        int idadeUsuario = sc.nextInt();

        System.out.println("Você é de qual cidade?");
        String cidadeUsuario = sc.next();

        System.out.println("Qual nome do seu Estado?");
        sc.nextLine();

        String estadoUsuario = sc.nextLine();
        System.out.println("Olá seu nome é " + nomeUsuario + "," + "você tem " + idadeUsuario + " anos," + "é da cidade de " + cidadeUsuario +"," + "situada no estado de " + estadoUsuario +".");
    }
}
