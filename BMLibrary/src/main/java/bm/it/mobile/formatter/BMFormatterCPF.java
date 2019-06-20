package bm.it.mobile.formatter;

import br.com.caelum.stella.format.CPFFormatter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class BMFormatterCPF {

    private final String cpf;

    public BMFormatterCPF(String cpf) {
        this.cpf = cpf;
    }

    public boolean isValidCPF() {
        return cpf != null && (!cpf.equals("") && cpf.length() == 11) && checkIfIsAValidCPFNumber();
    }

    private boolean checkIfIsAValidCPFNumber() {
        boolean isValid = true;
        try {
            CPFValidator cpfValidator = new CPFValidator();
            cpfValidator.assertValid(cpf);
        } catch (InvalidStateException e) {
            isValid = false;
            e.printStackTrace();
        }
        return isValid;
    }

    public String format() {
        CPFFormatter cpfFormatter = new CPFFormatter();
        return cpfFormatter.format(cpf);
    }

    public String unformat() {
        CPFFormatter cpfFormatter = new CPFFormatter();
        return cpfFormatter.unformat(cpf);
    }
}
