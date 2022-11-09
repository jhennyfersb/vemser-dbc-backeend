import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Exe2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("digite uma data inicial ");
        String inicialDate = sc.next();
        System.out.println("digite uma data final ");
        String finalDate = sc.next();

        LocalDate dataInicial = LocalDate.parse(inicialDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dataFinal = LocalDate.parse(finalDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Period between = Period.between(dataInicial, dataFinal);

        System.out.println("Duração : " + between.getYears() +
                " anos " + "e " + between.getMonths() +
                " meses " + between.getDays() + " dias");
    }
}
