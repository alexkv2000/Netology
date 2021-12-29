package day10.Utils;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author KAU
 * @project Netology
 * @create 2021-12-28 14:08
 */
public class DateUtil {
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    public static LocalDate addSDay(String date, int days) { //"YYYY-MM-DD"
        LocalDate day = LocalDate.parse(date);
        LocalDate newDate = day.plusDays(days);
        return newDate;
    }

}
