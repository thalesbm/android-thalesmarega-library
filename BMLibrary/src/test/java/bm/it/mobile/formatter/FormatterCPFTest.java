package bm.it.mobile.formatter;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class FormatterCPFTest {

    @Test
    public void checkIfCPFIsEmpty() {
        BMFormatterCPF cpf = new BMFormatterCPF("");

        assertFalse(cpf.isValidCPF());
    }

    @Test
    public void checkIfCPFIsNull() {
        BMFormatterCPF cpf = new BMFormatterCPF(null);

        assertFalse(cpf.isValidCPF());
    }

    @Test
    public void checkIfCPFHasLessThanElevenLength() {
        BMFormatterCPF cpf = new BMFormatterCPF("1234567890");

        assertFalse(cpf.isValidCPF());
    }

    @Test
    public void checkIfCPFHasMoreThanElevenLength() {
        BMFormatterCPF cpf = new BMFormatterCPF("123456789012");

        assertFalse(cpf.isValidCPF());
    }

    @Test
    public void checkIfIsValidCPFNumber() {
        BMFormatterCPF cpf = new BMFormatterCPF("12345678901");

        assertFalse(cpf.isValidCPF());
    }

    @Test
    public void checkIfIsValidCPFNumber2() {
        BMFormatterCPF cpf = new BMFormatterCPF("23125882850");

        assertTrue(cpf.isValidCPF());
    }

    @Test
    public void checkFormatter() {
        BMFormatterCPF cpf = new BMFormatterCPF("23125882850");

        assertEquals("231.258.828-50", cpf.format());
    }

    @Test
    public void checkUnformat() {
        BMFormatterCPF cpf = new BMFormatterCPF("231.258.828-50");

        assertEquals("23125882850", cpf.unformat());
    }
}
