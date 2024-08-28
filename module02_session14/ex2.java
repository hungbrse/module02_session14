package module02_session14;


import java.time.*;
import java.time.format.DateTimeFormatter;

public class ex2 {
    public static void main(String[] args) {

        ZonedDateTime currentSystemDateTime = ZonedDateTime.now();


        ZonedDateTime tokyoDateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        ZonedDateTime sydneyDateTime = ZonedDateTime.now(ZoneId.of("Australia/Sydney"));
        ZonedDateTime saoPauloDateTime = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));

        // Định dạng thời gian cho dễ đọc
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");

        // In ra kết quả
        System.out.println("Current system time: " + currentSystemDateTime.format(formatter));
        System.out.println("Tokyo time: " + tokyoDateTime.format(formatter));
        System.out.println("Sydney time: " + sydneyDateTime.format(formatter));
        System.out.println("Sao Paulo time: " + saoPauloDateTime.format(formatter));


        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("thời gian hiện tại :" + ldt);

        YearMonth currentYearMonth = YearMonth.now();

        int daysinMouth =  currentYearMonth.lengthOfMonth();
        int daysinYear =  currentYearMonth.lengthOfYear();

        System.out.println(daysinMouth);
        System.out.println(daysinYear);

        String dateString = "26/08/2024";

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate date = LocalDate.parse(dateString, format);

        System.out.println("Ngày đã chuyển đổi: " + date);


        String dateString1 = date.format(format);

        System.out.println("Chuỗi ngày: " + dateString1);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String dateTimeString = ldt.format(dateTimeFormatter);

        System.out.println(dateTimeString);

        LocalDate date1 = LocalDate.of(2024, 8, 26);
        LocalDate date2 = LocalDate.of(2023, 1, 26);

        int comparisonResult = date1.compareTo(date2);

        System.out.println("Kết quả so sánh: " + comparisonResult);
        LocalTime time1 = LocalTime.of(10, 30, 0);
        LocalTime time2 = LocalTime.of(12, 15, 0);

        int timeResult = time1.compareTo(time2);

        System.out.println("Kết quả so sánh: " +timeResult);


    }
}
