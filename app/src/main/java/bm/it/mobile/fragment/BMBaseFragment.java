package bm.it.mobile.fragment;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import static bm.it.mobile.util.BMUtils.setLayoutParamsInImageView;

public class BMBaseFragment extends Fragment {

    protected void hideKeyboard() {
        View view = getActivity().findViewById(android.R.id.content);
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void changeFocusEditText(EditText editText, final ImageView imageView, final int drawableFocus, final int drawableNoFocus) {
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean focus) {
                if (focus) {
                    imageView.setBackgroundResource(drawableFocus);
                } else {
                    imageView.setBackgroundResource(drawableNoFocus);
                }
            }
        });
    }

    protected boolean validate(String messageError, EditText editText, TextInputLayout textInputLayout,
                               ImageView imageView1, ImageView imageView2, int imageView2Size) {
        if (editText.getText().toString().trim().isEmpty()) {
            textInputLayout.setError(messageError);
            imageView1.setLayoutParams(setLayoutParamsInImageView(getContext(), 3, false));
            imageView2.setLayoutParams(setLayoutParamsInImageView(getContext(), 3, false, imageView2Size));
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
            imageView1.setLayoutParams(setLayoutParamsInImageView(getContext(), 7, true));
            imageView2.setLayoutParams(setLayoutParamsInImageView(getContext(), 7, true, imageView2Size));
        }
        return true;
    }

    protected boolean validate(String messageError, EditText editText, TextInputLayout textInputLayout, ImageView imageView) {
        if (editText.getText().toString().trim().isEmpty()) {
            textInputLayout.setError(messageError);
            imageView.setLayoutParams(setLayoutParamsInImageView(getContext(), 3, false));
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
            imageView.setLayoutParams(setLayoutParamsInImageView(getContext(), 7, true));
        }
        return true;
    }

    protected boolean validate(String messageError, EditText editText, TextInputLayout textInputLayout, ImageView imageView, Animation animation) {
        if (editText.getText().toString().trim().isEmpty()) {
            textInputLayout.setError(messageError);
            editText.startAnimation(animation);
            imageView.setLayoutParams(setLayoutParamsInImageView(getContext(), 3, false));
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
            editText.clearAnimation();
            imageView.setLayoutParams(setLayoutParamsInImageView(getContext(), 7, true));
        }
        return true;
    }
}