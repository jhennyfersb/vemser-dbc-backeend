package exercicio7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] produto = new double[11][3];
        double superMercadoMaisBarato = 0;
        int supermercado;

        for (int i = 0; i < 3; i++) {
            System.out.println("Digite o valor do item 1");
            produto[i][0] = sc.nextDouble();
            System.out.println("Digite o valor do item 2");
            produto[i][1] = sc.nextDouble();
            System.out.println("Digite o valor do item 3");
            produto[i][2] = sc.nextDouble();
            System.out.println("Digite o valor do item 4");
            produto[i][3] = sc.nextDouble();
            System.out.println("Digite o valor do item 5");
            produto[i][4] = sc.nextDouble();
            System.out.println("Digite o valor do item 6");
            produto[i][5] = sc.nextDouble();
            System.out.println("Digite o valor do item 7");
            produto[i][6] = sc.nextDouble();
            System.out.println("Digite o valor do item 8");
            produto[i][7] = sc.nextDouble();
            System.out.println("Digite o valor do item 9");
            produto[i][8] = sc.nextDouble();
            System.out.println("Digite o valor do item 10");
            produto[i][9] = sc.nextDouble();
            produto[i][10] = produto[i][0] + produto[i][1] + produto[i][2] + produto[i][3] + produto[i][4] +
                    produto[i][5] + produto[i][6] + produto[i][7] + produto[i][8] + produto[i][9];
        }
        if(produto[0][10] > produto[1][10]){
            superMercadoMaisBarato = produto[1][10];
            supermercado = 2;
            if(superMercadoMaisBarato > produto[2][10]){
                supermercado = 3;
                superMercadoMaisBarato = produto[2][10];
            }
        }else {
            supermercado = 1;
            superMercadoMaisBarato = produto[0][10];
            if (superMercadoMaisBarato > produto[2][10]){
                supermercado = 3;
                superMercadoMaisBarato = produto[2][10];
            }
        }
        System.out.println("O supermercado mais barato é o supermercado" + supermercado );
    }
}
