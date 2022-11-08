package exercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String estado = sc.nextLine();
        String cidade;

        switch (estado) {
            case "Parana" -> {
                System.out.println("Digite uma cidade : Pato Branco ou Curitiba");
                cidade = sc.next();
                if (cidade.equals("Pato Branco")) {
                    System.out.println("Sua população 82.881 habitantes," +
                            " e com índice de desenvolvimento humano (IDH de 2010) de 0.782, " +
                            "e sua maior festa é o desfile de natal");
                } else if (cidade.equals("Curitiba")) {
                    System.out.println("Índice de Desenvolvimento Humano (IDH) de 0,862," +
                            "tem 1.933.105 habitantes, " +
                            "sua maior festa é o festival de Teatro toma conta da cidade");
                }
            }
            case "Santa Catarina" -> {
                System.out.println("Digite uma cidade : Florianópolis ou Lages");
                cidade = sc.next();
                if (cidade.equals("Florianópolis")) {
                    System.out.println("É a capital com o maior Índice de Desenvolvimento Humano, medido em 0,847 no ano de 2019, " +
                            "e sua população é de 516.524 habitantes (estimativa IBGE 2021), " +
                            "sua maior festa é  o festival Subtropikal.");
                } else if (cidade.equals("Lages")) {
                    System.out.println("Índice de Desenvolvimento Humano (IDH) de 0,770  "+
                            "e sua população é de 157.158 habitantes " +
                            "Sua maior festa é a festa do Pinhão");
                }
            }
            case "Para" -> {
                System.out.println("Digite uma cidade : Itaituba ou Santarem");
                cidade = sc.next();
                if (cidade.equals("Itaituba")) {
                    System.out.println("Índice de Desenvolvimento Humano (IDH) de 0,640," +
                            "e sua população é de 101.395 habitantes," +
                            "sua maior festa é  a Festa da Senhora de Sant'ana");
                } else if (cidade.equals("Santarem")) {
                    System.out.println("Índice de Desenvolvimento Humano (IDH) de 0,691 ," +
                            "e sua população é de 306.480 habitantes, sua maior festa é  o festival Sairé");
                }
            }
            default -> System.out.println("Não contem esse estado");
        }
    }
}
