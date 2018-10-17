package bm.it.mobile.formatter;

public class BMFormatterPhone {

    private final String phone;

    private final String REGEX = "([0-9]{2})([0-9]{4,5})([0-9]{4})";
    private final String FORMAT = "($1) $2-$3";

    public BMFormatterPhone(String phone) {
        this.phone = phone;
    }

    public boolean isValidPhone() {
        return phone != null && (phone.length() == 10 || phone.length() == 11);
    }

    public String format() {
        return phone.replaceAll(REGEX, FORMAT);
    }

    public String unformat() {
        return phone
                .replace("(", "")
                .replace(") ", "")
                .replace(" ", "")
                .replace("-", "");
    }
}
