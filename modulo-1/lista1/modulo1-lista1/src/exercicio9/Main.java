package exercicio9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Em que hora iniciou o jogo ?");
        int inicioJogoHora = sc.nextInt();
        System.out.println("Em que minuto iniciou o jogo?");
        int inicioJogoMinuto = sc.nextInt();

        System.out.println("Em Que hora finalizou o jogo ?");
        int fimJogoHora = sc.nextInt();
        System.out.println("Em que minuto finalizou o jogo ?");
        int fimJogoMinuto = sc.nextInt();

        int inicioJogo = inicioJogoHora * 60 + inicioJogoMinuto;
        int fimJogo = fimJogoHora * 60 + fimJogoMinuto;
        int tempoJogo;
        if (inicioJogo < fimJogo) {
            tempoJogo = fimJogo - inicioJogo;
        } else {
            tempoJogo = (24 * 60 + fimJogo) - inicioJogo;
        }
        int horasJogo = tempoJogo / 60;
        int minutosJogo = tempoJogo % 60;
        System.out.println("O jogo durou " + horasJogo + " horas e " + minutosJogo + " minutos.");
    }
}
