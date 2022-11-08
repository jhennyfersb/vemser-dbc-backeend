package exe1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {
    public static void main(String[] args) {
        System.out.println("digite sua data de aniversario dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        String dataAniversario = sc.next();

        LocalDate minhaDataAniversario = LocalDate.parse(dataAniversario, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalDate aniversarioEsseAno = LocalDate.of(2022, minhaDataAniversario.getMonth(), minhaDataAniversario.getDayOfMonth());
        System.out.print("Faltam " + ChronoUnit.MONTHS.between(LocalDate.now(), aniversarioEsseAno) + " meses ");
        System.out.print(" e " + DAYS.between(LocalDate.now(), aniversarioEsseAno) + " dias");
    }
}