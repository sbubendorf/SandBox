package ch.rusi.sandbox.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DateDifference {

    /*
        Calculate approximate but better readable difference between time and date
        Example:

            Calculate duration until now (2020.10.27 21:42:10) :
            2020.09.15 02:48:19 :    3696831 seconds -   1 Months
            2020.10.07 08:07:51 :    1776859 seconds -  20 Days
            2020.10.27 20:15:06 :       5224 seconds -   1 Hours

     */

    private static final String dateFormat = "yyyy.MM.dd";
    private static final String timeFormat = "HH:mm:ss";

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat + " " + timeFormat);

    private static List<ChronoUnit> timeUnits = Arrays.asList(
            ChronoUnit.SECONDS,
            ChronoUnit.MINUTES,
            ChronoUnit.HOURS,
            ChronoUnit.DAYS,
            ChronoUnit.MONTHS,
            ChronoUnit.YEARS,
            ChronoUnit.CENTURIES
    );

    public static void main(String[] args) {

        Random rand = new Random();

        LocalDateTime now = LocalDateTime.now();
        System.out.println("Calculate duration until now (" + dtf.format(now) + ") : ");
        for (Long seconds : rand.longs(100, 1, 10000000).toArray()) {
            LocalDateTime past = now.minusSeconds(seconds);
            System.out.print(dtf.format(past) + " : " + String.format("%1$10s", seconds) + " seconds - ");
            for (int i = 1; i < timeUnits.size(); i++) {
                long diffTimeUnit = timeUnits.get(i).between(past, now);
                if (diffTimeUnit == 0) {
                    // Diff in seconds is lower than the current time unit --> show diff in previous time unit!
                    long diffShow = timeUnits.get(i - 1).between(past, now);
                    System.out.println(String.format("%3s", diffShow) + " " + timeUnits.get(i - 1).toString());
                    break;
                }
            }
        }
    }
}
