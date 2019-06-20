package bm.it.mobile.utils;

import junit.framework.Assert;

import org.junit.Test;

import java.util.Calendar;

import static junit.framework.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class DateUtilsTest {

    @Test
    public void checkIfDateIsFormatted() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1992, 10, 10);

        assertEquals("10/11/1992", BMDateUtils.formatDate(calendar.getTime()));
    }

    @Test
    public void checkIfDateIsFormattedWithHour() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1992, 10, 10, 20, 18);

        assertEquals("10/11/1992 20:18", BMDateUtils.formatDateWithHour(calendar.getTime()));
    }

    @Test
    public void checkIfDateEqual() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1992, 10, 10, 20, 18);

        Assert.assertTrue(BMDateUtils.compareDate(calendar.getTime(), calendar.getTime()));
    }

    @Test
    public void checkIfDateNotEqual() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1992, 10, 10, 20, 18);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(1993, 10, 10, 20, 18);

        assertFalse(BMDateUtils.compareDate(calendar.getTime(), calendar1.getTime()));
    }
}
