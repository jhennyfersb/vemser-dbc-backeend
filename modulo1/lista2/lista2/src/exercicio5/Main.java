package exercicio5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] matriz = new double[5][4];
        double matriculaDoMaior = 0;
        double notaFinalDoMaior = 0;
        double somaDasNotas = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Digite o numero da matricula");
            matriz[i][0] = sc.nextDouble();
            System.out.println("Digite a media das provas");
            matriz[i][1] = sc.nextDouble();
            System.out.println("Digite a media dos trabalhos");
            matriz[i][2] = sc.nextDouble();
            matriz[i][3] = ( matriz[i][1] * 0.6 * matriz[i][2] * 0.4 );
            somaDasNotas += matriz[i][3];

            if(matriz[i][3] > notaFinalDoMaior){
                notaFinalDoMaior = matriz[i][3];
                matriculaDoMaior = matriz[i][0];
            }
        }
        System.out.format("A matrícula que obteve a maior nota final é %.2f\n" , matriculaDoMaior);
        System.out.format("A média das notas finais é %.2f\n" , somaDasNotas/5);
    }
}
