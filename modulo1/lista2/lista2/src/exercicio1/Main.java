package exercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do produto");
        String nomeProduto = sc.next();
        System.out.println("Digite o preço do produto");
        double valorProduto = sc.nextDouble();

        System.out.println("Produto: " + nomeProduto);
        System.out.println("Preço R$: " + valorProduto);
        System.out.println("Promoção: " + nomeProduto);
        for (int i = 1; i <= 10; i++) {
            double desconto = valorProduto - (valorProduto * (0.05 * i));
            System.out.format(i + " x " + "R$ %.2f", desconto);
            System.out.format(" = R$ %.2f\n", i * desconto);
        }
    }
}
