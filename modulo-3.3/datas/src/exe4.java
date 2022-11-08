import java.time.*;

public class exe4 {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("Europe/London");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);

        ZonedDateTime diaDoShow = ZonedDateTime.parse("2024-09-14T18:30:00+01:00[Europe/London]");

        Period betWeen = Period.between(zonedDateTime.toLocalDate(), diaDoShow.toLocalDate());

        System.out.print(betWeen.getYears() + " anos ");
        System.out.print(betWeen.getMonths() + " meses ");
        System.out.println(betWeen.getDays() + " dias ");

        Duration duration = Duration.between(zonedDateTime,diaDoShow);
        long horas = duration.toHours() % 24;
        long minutos = duration.toMinutes() % 60;
        long segundos = duration.toSeconds() % 60;

        System.out.print(horas + " horas ");
        System.out.print(minutos + " minutos ");
        System.out.print(segundos + " segundos");
    }
}
