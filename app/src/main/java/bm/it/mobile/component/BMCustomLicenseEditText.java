package bm.it.mobile.component;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;

public class BMCustomLicenseEditText extends android.support.v7.widget.AppCompatEditText implements
        TextWatcher { // View.OnKeyListener,

    private final String TAG = BMCustomLicenseEditText.class.getSimpleName();

    // private boolean mKeyDel;
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
//        setOnKeyListener(this);
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
//        Log.d(TAG, text + " - " + mKeyDel);

        if (text != null && !mDeletedFormatted) {

            if (text.length() == 3) {
                text.insert(3, "-");
            }
        }
    }

//    @Override
//    public boolean onKey(View v, int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_DEL) {
//            this.mKeyDel = true;
//        } else {
//            this.mKeyDel = false;
//        }
//        return false;
//    }
}