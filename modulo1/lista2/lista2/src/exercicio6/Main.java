package exercicio6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] notaAluno = new double[5][5];
        double somaNotasAluno = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite a av1 do aluno");
            notaAluno[i][0] = sc.nextDouble();
            System.out.println("Digite a av2 do aluno");
            notaAluno[i][1] = sc.nextDouble();
            System.out.println("Digite a av3 do aluno");
            notaAluno[i][2] = sc.nextDouble();
            System.out.println("Digite a av4 do aluno");
            notaAluno[i][3] = sc.nextDouble();
            notaAluno[i][4] = (notaAluno[i][0] + notaAluno[i][1] + notaAluno[i][2] + notaAluno[i][3]) / 4;
            somaNotasAluno += notaAluno[i][0] + notaAluno[i][1] + notaAluno[i][2] + notaAluno[i][3];

        }
        System.out.println("A média da disciplina de matemática é " + notaAluno[0][4]);
        System.out.println("A média da disciplina de português é " + notaAluno[1][4]);
        System.out.println("A média da disciplina de ciências é " + notaAluno[2][4]);
        System.out.println("A média da disciplina de geografia é " + notaAluno[3][4]);
        System.out.println("A média da disciplina de história é " + notaAluno[4][4]);
        System.out.println("A média geral obtida pelo aluno em todas as disciplinas é " + somaNotasAluno / 5);
    }
}
