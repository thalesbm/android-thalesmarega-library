package bm.it.mobile.ui.component;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

public class BMCustomLicenseEditText extends android.support.v7.widget.AppCompatEditText implements
        TextWatcher {

    private boolean mDeletedFormatted = false;

    public BMCustomLicenseEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public BMCustomLicenseEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BMCustomLicenseEditText(Context context) {
        super(context);
        init();
    }

    public void init() {
        addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        if (count > after) {
            if (after == 3) {
                mDeletedFormatted = true;
            } else {
                mDeletedFormatted = false;
            }
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable text) {
        if (text != null && !mDeletedFormatted) {

            if (text.length() == 3) {
                text.insert(3, "-");
            }
        }
    }
}