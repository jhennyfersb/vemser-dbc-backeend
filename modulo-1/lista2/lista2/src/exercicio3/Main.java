package exercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite nome de um jogador");
        String nomeJogador = sc.next();
        int contJogador = 0;
        double jogadorMaisVelho = 0;
        double jogadorMaisPesado = 0.0;
        double alturaJogadorMaisAlto = 0;
        double somaJogadoresMaisAltos = 0;
        String nomeJogadorMaisVelho = "";
        String nomeJogadorMaisPesado = "";

        while (!(nomeJogador.equals("SAIR"))){
            contJogador++;
            System.out.println("Digite altura do jogador");
            double alturaJogador = sc.nextDouble();
            System.out.println("Digite idade do jogador");
            int idadeJogador = sc.nextInt();
            System.out.println("Digite peso do jogador");
            double pesoJogador = sc.nextDouble();
            somaJogadoresMaisAltos += alturaJogador;
            alturaJogadorMaisAlto = Math.max(alturaJogador,alturaJogadorMaisAlto);

            if (jogadorMaisVelho < idadeJogador){
                jogadorMaisVelho = idadeJogador;
                nomeJogadorMaisVelho = nomeJogador;
            }
            if (jogadorMaisPesado < pesoJogador){
                jogadorMaisPesado = pesoJogador;
                nomeJogadorMaisPesado = nomeJogador;
            }
            System.out.println("Digite nome do jogador");
            nomeJogador = sc.next();
        }
        System.out.println("Quantidade de jogadores cadastrados: " + contJogador);
        System.out.println("Altura do maior Jogador: " + alturaJogadorMaisAlto);
        System.out.println("Jogador mais velho: "+ nomeJogadorMaisVelho);
        System.out.println("Jogador mais pesado: " + nomeJogadorMaisPesado);
        System.out.format("Média das alturas jogadores: %.2f" ,somaJogadoresMaisAltos/contJogador);
    }
}
