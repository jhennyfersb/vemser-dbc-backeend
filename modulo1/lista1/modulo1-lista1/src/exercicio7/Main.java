package exercicio7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Qual o código do produto?");
        String codigoProduto = sc.next();

        System.out.println("Qual a quantidade comprada do produto?");
        int quantProduto = sc.nextInt();

        System.out.println("Qual o preço do produto?");
        Double precoProduto = sc.nextDouble();

        Double valorTotal = quantProduto * precoProduto;

        System.out.println("codigo " + codigoProduto + " preco unitario = R$ " + precoProduto + " valor total = R$  " + valorTotal);


    }
}
