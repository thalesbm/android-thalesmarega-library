package bm.it.mobile.activity;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class BMBaseActivity extends AppCompatActivity {

    private Toolbar toolbar;

    public void setupToolbar(View toolbarView) {
        toolbar = (Toolbar) toolbarView;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    public void changeToolbarTitle(String title) {
        if (toolbar != null) {
            toolbar.setTitle(title);
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
            View view = findViewById(android.R.id.content);
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onBackPressed(String defaultFragmentName, FragmentManager fragmentManager,
                              int drawerID, NavigationView navigationView) {
        DrawerLayout drawer = (DrawerLayout) findViewById(drawerID);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            if (fragmentManager == null) {
                super.onBackPressed();
            } else {
                int sizeStack = fragmentManager.getBackStackEntryCount() - 1;

                if (fragmentManager.getBackStackEntryCount() > 0) {
                    String className = fragmentManager.getBackStackEntryAt(sizeStack).getName();
                    if (className.equals(defaultFragmentName)) {
                        finish();
                    } else {
                        navigationView.getMenu().getItem(0).setChecked(true);
                        for (int i = 0; i < fragmentManager.getBackStackEntryCount(); ++i) {
                            fragmentManager.popBackStack();
                        }
                    }
                } else {
                    super.onBackPressed();
                }
            }
        }
    }

    protected void replaceFragment(Fragment fragment, boolean addToBackStack, int navDrawerContainer) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(navDrawerContainer, fragment);
        if (addToBackStack) {
            fragmentTransaction.addToBackStack(fragment.getClass().getName());
        }
        fragmentTransaction.commit();
    }
}
