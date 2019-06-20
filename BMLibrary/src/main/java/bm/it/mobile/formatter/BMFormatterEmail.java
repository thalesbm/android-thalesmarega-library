package bm.it.mobile.formatter;

public class BMFormatterEmail {

    private final String email;

    private final String REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public BMFormatterEmail(String email) {
        this.email = email;
    }

    public boolean isValidEmail() {
        return email != null && (!email.trim().isEmpty() && email.matches(REGEX));
    }
}
