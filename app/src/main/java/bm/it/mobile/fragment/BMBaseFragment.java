package bm.it.mobile.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import android.view.View;

import bm.it.mobile.activity.BMBaseActivity;

public class BMBaseFragment extends Fragment {

    protected BMBaseActivity getAppActivity() {
        return (BMBaseActivity) getActivity();
    }

    public View getView() {
        return getAppActivity().findViewById(android.R.id.content);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            getAppActivity().finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected();
    }
}
