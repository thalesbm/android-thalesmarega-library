package bm.it.mobile.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String formatDate(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(date);
    }

    public static String formatDateWithHour(Date date) {
        return new SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.ENGLISH).format(date);
    }
}
