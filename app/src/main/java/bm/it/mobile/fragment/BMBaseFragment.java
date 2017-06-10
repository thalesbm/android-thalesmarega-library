package bm.it.mobile.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v4.app.Fragment;

public class BMBaseFragment extends Fragment {

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected();
    }
}
