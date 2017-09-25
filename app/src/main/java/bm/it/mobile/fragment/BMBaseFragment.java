package bm.it.mobile.fragment;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import bm.it.mobile.activity.BMBaseActivity;

public class BMBaseFragment extends Fragment {

    private BMBaseActivity getBaseActivity() {
        return (BMBaseActivity) getActivity();
    }


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
        return getBaseActivity().validate(messageError, editText, textInputLayout, imageView1, imageView2, imageView2Size);
    }

    protected boolean validate(String messageError, EditText editText, TextInputLayout textInputLayout, ImageView imageView) {
        return getBaseActivity().validate(messageError, editText, textInputLayout, imageView);
    }

    protected boolean validate(String messageError, EditText editText, TextInputLayout textInputLayout, ImageView imageView, Animation animation) {
        return getBaseActivity().validate(messageError, editText, textInputLayout, imageView, animation);
    }
}