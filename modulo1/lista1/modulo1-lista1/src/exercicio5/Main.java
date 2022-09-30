package exercicio5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a base do retângulo ?");
        double base = sc.nextDouble();

        System.out.println("Qual a altura do retângulo em metros?");
        double altura = sc.nextDouble();

        double area = base * altura;

        System.out.println("A area do retângulo é " + area + " m2");
    }
}
