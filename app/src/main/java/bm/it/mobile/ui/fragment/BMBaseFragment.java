package bm.it.mobile.ui.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import bm.it.mobile.ui.activity.BMBaseActivity;

public class BMBaseFragment extends Fragment {

    private BMBaseActivity getBaseActivity() {
        return (BMBaseActivity) getActivity();
    }

    protected void setupToolbar(View toolbarView) {
        getBaseActivity().setupToolbar(toolbarView);
    }

    protected void changeToolbarTitle(String title) {
        getBaseActivity().changeToolbarTitle(title);
    }

    protected void setToolbarProperties(String title) {
        getBaseActivity().setToolbarProperties(title);
    }

    protected Toolbar getToolbar() {
        return getBaseActivity().getToolbar();
    }

    protected void hideKeyboard() {
        getBaseActivity().hideKeyboard();
    }

    protected void changeFocusEditText(EditText editText, final ImageView imageView,
                                       final int drawableFocus, final int drawableNoFocus) {
        getBaseActivity().changeFocusEditText(editText, imageView, drawableFocus, drawableNoFocus);
    }

    protected boolean validate(String messageError, EditText editText, TextInputLayout textInputLayout,
                               ImageView imageView1, ImageView imageView2, int imageView2Size) {
        return getBaseActivity().validate(messageError, editText, textInputLayout, imageView1, imageView2, imageView2Size);
    }

    protected boolean validate(String messageError, EditText editText, TextInputLayout textInputLayout,
                               ImageView imageView) {
        return getBaseActivity().validate(messageError, editText, textInputLayout, imageView);
    }

    protected boolean validate(String messageError, EditText editText, TextInputLayout textInputLayout,
                               ImageView imageView, Animation animation) {
        return getBaseActivity().validate(messageError, editText, textInputLayout, imageView, animation);
    }

    protected boolean validate(@NonNull Spinner spinner, @Nullable Animation animation, boolean showError) {
        return getBaseActivity().validate(spinner, animation, showError);
    }

    protected boolean validate(@NonNull Spinner spinner, boolean showError) {
        return getBaseActivity().validate(spinner, null, showError);
    }
}