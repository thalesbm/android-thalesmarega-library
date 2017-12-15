package bm.it.mobile.component;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * @author tmarega
 */
public abstract class CustomTextWatcher implements TextWatcher {
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
