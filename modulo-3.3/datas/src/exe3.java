import java.time.LocalDateTime;

public class exe3 {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.plusDays(15);
        localDateTime = localDateTime.plusHours(10);

        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear() + " dias do ano");
        System.out.println(localDateTime.getHour() + " horas");

    }
}