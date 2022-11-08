package exercicio10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o nome do aluno ?");
        String aluno = sc.nextLine();

        System.out.println("Qual a nota1 do aluno ?");
        double nota1 = sc.nextDouble();

        System.out.println("Qual a nota2 do aluno ?");
        double nota2 = sc.nextDouble();

        System.out.println("Qual a nota3 do aluno ?");
        double nota3 = sc.nextDouble();

        System.out.println("Qual a media de aproveitamento do aluno ?");
        double ME = sc.nextDouble();

        double media = (nota1 + (nota2 * 2) + (nota3 * 3) + ME) / 7;

        if (media < 4) {
            System.out.println(aluno + " nota1 = " + nota1 + " nota = " + nota2 + " nota3 = " + nota3 + " Media de aproveitamento " + media + " Sua nota = E" + " Você foi Reprovado");
        } else if (media > 4 && media <= 6.0) {
            System.out.println(aluno + " nota1 = " + nota1 + " nota = " + nota2 + " nota3 = " + nota3 + " Media de aproveitamento " + media + "Sua nota = D" + " Você foi Reprovado");
        } else if (media >= 6.0 && media < 7.5) {
            System.out.println(aluno + " nota1 = " + nota1 + " nota = " + nota2 + " nota3 = " + nota3 + " Media de aproveitamento " + "Sua nota = C" + " Você foi Aprovado");
        } else if (media >= 7.5 && media < 9.0) {
            System.out.println(aluno + " nota1 = " + nota1 + " nota = " + nota2 + " nota3 = " + nota3 + " Media de aproveitamento " + "Sua nota = B" + " Você foi Aprovado");
        } else if (media >= 90 && media <= 100) {
            System.out.println(aluno + " nota1 = " + nota1 + " nota = " + nota2 + " nota3 = " + nota3 + " Media de aproveitamento " + "Sua nota = A" + " Você foi Aprovado");
        }
    }

}
