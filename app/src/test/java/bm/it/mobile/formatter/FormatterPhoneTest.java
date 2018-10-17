package bm.it.mobile.formatter;

import org.junit.Test;

import bm.it.mobile.formatter.BMFormatterPhone;

import static junit.framework.Assert.*;

public class FormatterPhoneTest {

    @Test
    public void checkIfPhoneHasLessThanElevenLength() {
        BMFormatterPhone phone = new BMFormatterPhone("12345678");

        assertFalse(phone.isValidPhone());
    }

    @Test
    public void checkIfPhoneIsEmpty() {
        BMFormatterPhone phone = new BMFormatterPhone("");

        assertFalse(phone.isValidPhone());
    }

    @Test
    public void checkIfPhoneIsNull() {
        BMFormatterPhone phone = new BMFormatterPhone(null);

        assertFalse(phone.isValidPhone());
    }

    @Test
    public void checkIfPhoneHasMoreThanElevenLength() {
        BMFormatterPhone phone = new BMFormatterPhone("123456789012");

        assertFalse(phone.isValidPhone());
    }

    @Test
    public void checkIfPhoneHasElevenLength() {
        BMFormatterPhone phone = new BMFormatterPhone("12345678901");

        assertTrue(phone.isValidPhone());
    }

    @Test
    public void checkIfPhoneHasTenLength() {
        BMFormatterPhone phone = new BMFormatterPhone("1234567890");

        assertTrue(phone.isValidPhone());
    }

    @Test
    public void checkIfPhoneIsFormattedWithTenLength() {
        BMFormatterPhone phone = new BMFormatterPhone("1234567890");

        assertEquals("(12) 3456-7890", phone.format());
    }

    @Test
    public void checkIfPhoneIsFormattedWithElevenLength() {
        BMFormatterPhone phone = new BMFormatterPhone("12345678901");

        assertEquals("(12) 34567-8901", phone.format());
    }

    @Test
    public void checkIfPhoneIsUnformatted() {
        BMFormatterPhone phone = new BMFormatterPhone("(12) 34567-8901");

        assertEquals("12345678901", phone.unformat());
    }
}