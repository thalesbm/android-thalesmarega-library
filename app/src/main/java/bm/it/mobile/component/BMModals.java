package bm.it.mobile.component;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;

import bm.it.mobile.R;
import bm.it.mobile.activity.BMBaseActivity;

public class BMModals {

    public static void showAlertDialog(String description, Activity activity) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.alert);
        builder.setMessage(description);

        builder.setNegativeButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
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
