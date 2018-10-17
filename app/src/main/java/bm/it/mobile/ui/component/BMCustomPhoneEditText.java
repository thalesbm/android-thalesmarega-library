package bm.it.mobile.ui.component;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

public class BMCustomPhoneEditText extends android.support.v7.widget.AppCompatEditText implements
        View.OnKeyListener, TextWatcher {

    private final String TAG = BMCustomPhoneEditText.class.getSimpleName();

    private boolean mHasNineNumbers;
    private boolean mKeyDel;

    public BMCustomPhoneEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public BMCustomPhoneEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BMCustomPhoneEditText(Context context) {
        super(context);
        init();
    }

    public void init() {
        setOnKeyListener(this);
        addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable text) {
        Log.d(TAG, text + " - " + mKeyDel);

        if (text != null && !mKeyDel) {

            if (text.length() == 1) {
                text.insert(0, "(");
            }

            if (text.length() == 3) {
                text.insert(3, ")");
            }

            if (text.length() == 4) {
                text.insert(4, " ");
            }

            if (mHasNineNumbers) {
                if (text.length() == 10) {
                    text.insert(10, "-");
                }
            } else {
                if (text.length() == 9) {
                    text.insert(9, "-");
                }
            }
        }
    }

    public void setHasNineNumbers(boolean hasNineNumbers) {
        this.mHasNineNumbers = hasNineNumbers;
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_DEL) {
            this.mKeyDel = true;
        } else {
            this.mKeyDel = false;
        }
        return false;
    }
}