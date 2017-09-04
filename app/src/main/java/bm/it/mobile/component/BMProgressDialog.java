package bm.it.mobile.component;

import android.app.Activity;
import android.app.ProgressDialog;

public class BMProgressDialog {
    private static ProgressDialog progressDialog;

    public static synchronized void showProgressDialog(Activity activity, String message) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.setMessage(message);
        } else {
            progressDialog = new ProgressDialog(activity);
            progressDialog.setMessage(message);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
    }

    public static synchronized void dismissProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}
