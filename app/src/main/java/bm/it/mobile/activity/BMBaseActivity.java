package bm.it.mobile.activity;

import android.content.Context;
import android.preference.PreferenceFragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import bm.it.mobile.R;

import static bm.it.mobile.util.BMUtils.setLayoutParamsInImageView;

public class BMBaseActivity extends AppCompatActivity {
    private final String TAG = BMBaseActivity.class.getSimpleName();

    private Toolbar toolbar;

    public void setupToolbar(View toolbarView) {
        toolbar = (Toolbar) toolbarView;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    public void changeToolbarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    public void setToolbarProperties(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            hideKeyboard();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void hideKeyboardWhenOpensMenu(DrawerLayout drawerLayout) {
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                Log.v(TAG, "onDrawerSlide(View drawerView, float slideOffset)");
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                Log.v(TAG, "nDrawerOpened(View drawerView)");
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                Log.v(TAG, "onDrawerClosed(View drawerView)");
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                Log.v(TAG, "onDrawerStateChanged(int newState)");
                hideKeyboard();
            }
        });
    }

    protected void hideKeyboard() {
        View view = findViewById(android.R.id.content);
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void onBackPressed(String defaultFragmentName, FragmentManager fragmentManagerApp4, android.app.FragmentManager mFragmentManagerApp, int drawerID, NavigationView navigationView) {
        DrawerLayout drawer = (DrawerLayout) this.findViewById(drawerID);
        if (drawer.isDrawerOpen(8388611)) {
            drawer.closeDrawer(8388611);
        } else if (fragmentManagerApp4 != null && mFragmentManagerApp != null) {
            int sizeStackApp;
            String className;
            int i;
            if (fragmentManagerApp4.getBackStackEntryCount() > 0) {
                sizeStackApp = fragmentManagerApp4.getBackStackEntryCount() - 1;
                className = fragmentManagerApp4.getBackStackEntryAt(sizeStackApp).getName();
                if (className.equals(defaultFragmentName)) {
                    this.finish();
                } else {
                    navigationView.getMenu().getItem(0).setChecked(true);

                    for (i = 0; i < fragmentManagerApp4.getBackStackEntryCount(); ++i) {
                        fragmentManagerApp4.popBackStack();
                        changeToolbarTitle(getString(R.string.app_name));
                    }
                }
            } else if (mFragmentManagerApp.getBackStackEntryCount() > 0) {
                sizeStackApp = mFragmentManagerApp.getBackStackEntryCount() - 1;
                className = mFragmentManagerApp.getBackStackEntryAt(sizeStackApp).getName();
                if (className.equals(defaultFragmentName)) {
                    this.finish();
                } else {
                    navigationView.getMenu().getItem(0).setChecked(true);

                    for (i = 0; i < mFragmentManagerApp.getBackStackEntryCount(); ++i) {
                        mFragmentManagerApp.popBackStack();
                        changeToolbarTitle(getString(R.string.app_name));
                    }
                }
            } else {
                super.onBackPressed();
            }
        } else {
            super.onBackPressed();
        }
    }

    protected void replacePreferenceFragment(PreferenceFragment fragment, boolean addToBackStack, int navDrawerContainer) {
        android.app.FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(navDrawerContainer, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }

        fragmentTransaction.commit();
    }

    protected void replaceFragment(Fragment fragment, boolean addToBackStack, int navDrawerContainer) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(navDrawerContainer, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
    }

    public void changeFocusEditText(EditText editText, final ImageView imageView, final int drawableFocus, final int drawableNoFocus) {
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

    private boolean validate(@NonNull String messageError, @NonNull EditText editText, @NonNull TextInputLayout textInputLayout,
                             @NonNull ImageView imageView1, @Nullable ImageView imageView2, @Nullable Integer imageView2Size, @Nullable Animation animation) {
        if (editText.getText().toString().trim().isEmpty()) {
            textInputLayout.setError(messageError);
            imageView1.setLayoutParams(setLayoutParamsInImageView(this, 3, false));
            if (imageView2 != null && imageView2Size != null) {
                imageView2.setLayoutParams(setLayoutParamsInImageView(this, 3, false, imageView2Size));
            }
            if (animation != null) {
                editText.startAnimation(animation);
            }
            return false;
        } else {
            textInputLayout.setErrorEnabled(false);
            imageView1.setLayoutParams(setLayoutParamsInImageView(this, 7, true));
            if (imageView2 != null && imageView2Size != null) {
                imageView2.setLayoutParams(setLayoutParamsInImageView(this, 7, true, imageView2Size));
            }
            if (animation != null) {
                editText.clearAnimation();
            }
        }
        return true;
    }

    public boolean validate(String messageError, EditText editText, TextInputLayout textInputLayout,
                            ImageView imageView1, ImageView imageView2, int imageView2Size) {
        return validate(messageError, editText, textInputLayout, imageView1, imageView2, imageView2Size, null);
    }

    public boolean validate(String messageError, EditText editText, TextInputLayout textInputLayout, ImageView imageView) {
        return validate(messageError, editText, textInputLayout, imageView, null, null, null);
    }

    public boolean validate(String messageError, EditText editText, TextInputLayout textInputLayout, ImageView imageView, Animation animation) {
        return validate(messageError, editText, textInputLayout, imageView, null, null, animation);
    }
}