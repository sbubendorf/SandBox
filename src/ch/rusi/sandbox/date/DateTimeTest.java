package ch.rusi.sandbox.date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTest {
	
	private static final String dateFormat = "dd.MM.yyyy";
	private static final String timeFormat = "HH.mm.ss";
	
    private static final DateFormat sdf = new SimpleDateFormat(dateFormat + " " + timeFormat);
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat + " " + timeFormat);

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);
        System.out.println(sdf.format(date));
        
        Calendar cal = Calendar.getInstance();
        System.out.println(sdf.format(cal.getTime()));

        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));

        // Get a pure date without any time portion
        LocalDate localDate = LocalDate.of(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH));
        System.out.println(DateTimeFormatter.ofPattern(dateFormat).format(localDate));
		
	}

}
