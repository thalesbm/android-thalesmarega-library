package bm.it.mobile.formatter;

import org.junit.Test;

import bm.it.mobile.formatter.BMFormatterEmail;

import static junit.framework.Assert.*;

public class FormatterEmailTest {

    @Test
    public void checkIfEmailIsEmpty() {
        BMFormatterEmail email = new BMFormatterEmail("");

        assertFalse(email.isValidEmail());
    }

    @Test
    public void checkIfEmailIsNull() {
        BMFormatterEmail email = new BMFormatterEmail(null);

        assertFalse(email.isValidEmail());
    }

    @Test
    public void checkIfEmailIsEmptyIsIncorrect() {
        BMFormatterEmail email = new BMFormatterEmail("thales");

        assertFalse(email.isValidEmail());
    }

    @Test
    public void checkIfEmailIsEmptyIsIncorrect1() {
        BMFormatterEmail email = new BMFormatterEmail("thales@");

        assertFalse(email.isValidEmail());
    }

    @Test
    public void checkIfEmailIsEmptyIsIncorrect2() {
        BMFormatterEmail email = new BMFormatterEmail("thales.bm@gmail");

        assertFalse(email.isValidEmail());
    }

    @Test
    public void checkIfEmailIsEmptyIsIncorrect3() {
        BMFormatterEmail email = new BMFormatterEmail("thales.bm@.");

        assertFalse(email.isValidEmail());
    }

    @Test
    public void checkIfEmailIsEmptyIsIncorrect4() {
        BMFormatterEmail email = new BMFormatterEmail("thales.bm@gmail.");

        assertFalse(email.isValidEmail());
    }

    @Test
    public void checkIfEmailIsEmptyIsCorrect() {
        BMFormatterEmail email = new BMFormatterEmail("thales.bm@gmail.com");

        assertTrue(email.isValidEmail());
    }
}
