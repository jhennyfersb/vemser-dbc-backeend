package exe4;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {
        ZoneId zoneId = ZoneId.of("Europe/London");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);

        ZonedDateTime diaDoShow = ZonedDateTime.parse("2024-09-14T10:18:30+01:00[Europe/London]");

        Period betWeen = Period.between(zonedDateTime.toLocalDate(), diaDoShow.toLocalDate());

        System.out.println(betWeen.getYears());
        System.out.println(betWeen.getMonths());
        System.out.println(betWeen.getDays());


        Duration betW = Duration.between(zonedDateTime.toLocalDate().atTime(LocalTime.ofSecondOfDay(zonedDateTime.getHour())),
                diaDoShow.toLocalDate().atTime(LocalTime.ofSecondOfDay(diaDoShow.getHour())));
        System.out.println(betW.toHours());
        System.out.println(betW.toMinutes());
        System.out.println(betW.toSeconds());
    }
}
