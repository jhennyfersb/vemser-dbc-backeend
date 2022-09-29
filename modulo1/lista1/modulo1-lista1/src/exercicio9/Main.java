package exercicio9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Quando iniciou o jogo ?");
        int inicioJogo = sc.nextInt();
        int convercaoHoras = inicioJogo/3600;
        inicioJogo = inicioJogo%3600;
        int conversaoMinutos = inicioJogo/60;
        int segundos = inicioJogo%60;

        System.out.println(convercaoHoras + ":" + conversaoMinutos +":" + segundos);

    }
}
