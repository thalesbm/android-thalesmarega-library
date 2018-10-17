package bm.it.mobile.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class BMDateUtils {

    public static String formatDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(date);
    }

    public static String formatDateWithHour(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.ENGLISH).format(date);
    }

    public static boolean compareDate(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }
}
