package java1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarProcessing {
    public static Calendar string2FullDate(String date) {
        Calendar calendar = new GregorianCalendar();
        int mounth = Integer.parseInt(date.substring(5, 7)) - 1;
        int year = Integer.parseInt(date.substring(0, 4));
        int day = Integer.parseInt(date.substring(8, 10));

        calendar.set(year, mounth,day);
        return calendar;
    }

    public static int dayCount(Calendar startDay, Calendar endDay){
        return endDay.get(Calendar.DAY_OF_YEAR)-startDay.get(Calendar.DAY_OF_YEAR);
    }
}
