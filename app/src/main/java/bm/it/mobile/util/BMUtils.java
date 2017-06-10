package bm.it.mobile.util;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.provider.Settings;

import bm.it.mobile.R;
import bm.it.mobile.activity.BMBaseActivity;

public class BMUtils {

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected();
    }

    public static void openInternetDialog(final BMBaseActivity activity) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity.getApplicationContext());
        alertDialogBuilder.setTitle(activity.getApplicationContext().getString(R.string.alert));
        alertDialogBuilder.setMessage(activity.getApplicationContext().getString(R.string.no_internet_description));
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton(activity.getApplicationContext().getString(R.string.yes), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                activity.startActivity(new Intent(Settings.ACTION_SETTINGS));
            }
        });
        alertDialogBuilder.setNegativeButton(activity.getApplicationContext().getString(R.string.no), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
