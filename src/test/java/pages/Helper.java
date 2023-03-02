package pages;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Helper {

    public static int getMonthDifferenceFromNow(int year, String monthStr) {
        // This method returns how many months in advance compared to the year and month passed on as parameters

        Month month;
        try {
            month = Month.valueOf(monthStr.toUpperCase());
        } catch (DateTimeParseException e) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM");
            throw new IllegalArgumentException("Invalid month name: " + monthStr + ". Month name should be in the format " + formatter.format(Month.JANUARY) + ".");
        }
        LocalDate currentDate = LocalDate.now();
        LocalDate inputDate = LocalDate.of(year, month, 1);
        int monthsDiff = (int) ChronoUnit.MONTHS.between(currentDate.withDayOfMonth(1), inputDate.withDayOfMonth(1));
        return Math.abs(monthsDiff)+1;
    }
}
