package exercicio8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual o salario do funcionario?");
        Double salario = sc.nextDouble();

        System.out.println("Qual o cargo do funcionario?");
        String cargo = sc.next();

        int codigo;
        Double aumentoSalario;

        switch (cargo) {
            case "Gerente" -> {
                codigo = 101;
                aumentoSalario = salario * 0.10;
            }
            case "Engenheiro" -> {
                codigo = 102;
                aumentoSalario = salario * 0.20;
            }
            case "Tecnico" -> {
                codigo = 103;
                aumentoSalario = salario * 0.30;
            }
            default -> aumentoSalario = salario * 0.40;
        }
        Double novoSalario = salario + aumentoSalario;

        System.out.println("salario anterior = R$ " + salario + " salario atual = R$ " + novoSalario + " aumento = R$ " + aumentoSalario);

    }
}
