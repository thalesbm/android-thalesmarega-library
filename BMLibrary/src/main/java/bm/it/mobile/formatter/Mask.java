package bm.it.mobile.formatter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class Mask implements TextWatcher {

    public static final String FORMAT_RG = "##.###.###-#";
    public static final String FORMAT_CPF = "###.###.###-##";
    public static final String FORMAT_PHONE = "(##)####-#####";
    public static final String FORMAT_CELLPHONE = "(##)#####-#####";
    public static final String FORMAT_CEP = "#####-###";
    public static final String FORMAT_DATE = "##/##/####";

    private boolean isUpdating;
    private String old = "";
    private String mask;
    private EditText editText;

    public Mask(String mask) {
        this.mask = mask;
    }

    private String unmask(String s) {
        return s.replaceAll("[.]", "").replaceAll("[-]", "")
                .replaceAll("[/]", "").replaceAll("[(]", "")
                .replaceAll("[)]", "");
    }

    public TextWatcher insert(final EditText editText) {
        this.editText = editText;
        return this;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String str = unmask(s.toString());
        String mask = "";

        if (isUpdating) {
            old = str;
            isUpdating = false;
            return;
        }

        int i = 0;

        for (char m : this.mask.toCharArray()) {
            if (m != '#' && str.length() > old.length()) {
                mask += m;
                continue;
            }
            try {
                mask += str.charAt(i);
            } catch (Exception e) {
                break;
            }
            i++;
        }

        isUpdating = true;
        editText.setText(mask);
        editText.setSelection(mask.length());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}