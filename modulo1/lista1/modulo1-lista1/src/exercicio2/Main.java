package exercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String estado = sc.next();
        String cidade ;

       switch (estado){
           case "Parana" ->{
               System.out.println("Digite uma cidade : Pato Branco ou Curitiba");
               cidade = sc.next();
               if (cidade == "Pato Branco"){
                   System.out.println("Sua população 82 881 habitantes, e com índice de desenvolvimento humano (IDH de 2010) de 0.782");
               } else if (cidade == "Curitiba") {
                   System.out.println("Índice de Desenvolvimento Humano (IDH) de 0,862,tem 1.933.105 habitantes");
               }
           }
           default -> System.out.println("Não contem esse estado");
       }
    }
}
