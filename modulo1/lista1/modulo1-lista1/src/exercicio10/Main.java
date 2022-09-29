package exercicio10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o nome do aluno ?");
        String aluno = sc.nextLine();

        System.out.println("Qual a nota1 do aluno ?");
        Double nota1 = sc.nextDouble();

        System.out.println("Qual a nota2 do aluno ?");
        Double nota2 = sc.nextDouble();

        System.out.println("Qual a nota3 do aluno ?");
        Double nota3 = sc.nextDouble();

        System.out.println("Qual a media de aproveitamento do aluno ?");
        Double ME = sc.nextDouble();

        Double media = (nota1 + nota2 * 2 + nota3 * 3 + ME) / 7;

        if (media < 4) {
            System.out.println(aluno + "nota1 = " + nota1 + " nota = " + nota2 + " nota3 = " + nota3 + " Media de aproveitamento " + media + " Sua nota = E" + " Reprovado");
        } else if (media > 4 && media <= 6.0) {
            System.out.println(aluno + "nota1 = " + nota1 + " nota = " + nota2 + " nota3 = " + nota3 + " Media de aproveitamento " + media + "Sua nota = D" + " Reprovado");
        } else if (media >= 6.0 && media < 7.5) {
            System.out.println(aluno + "nota1 = " + nota1 + " nota = " + nota2 + " nota3 = " + nota3 + " Media de aproveitamento " + "Sua nota = C" + " Aprovado");
        } else if (media >= 7.5 && media < 9.0) {
            System.out.println(aluno + "nota1 = " + nota1 + " nota = " + nota2 + " nota3 = " + nota3 + " Media de aproveitamento " + "Sua nota = B" + "Aprovado");
        } else if (media >= 90 && media <= 100) {
            System.out.println(aluno + "nota1 = " + nota1 + " nota = " + nota2 + " nota3 = " + nota3 + " Media de aproveitamento " + "Sua nota = A" + "Aprovado");
        }
    }

}
