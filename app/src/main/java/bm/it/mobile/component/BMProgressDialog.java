package bm.it.mobile.component;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

public class BMProgressDialog extends ProgressDialog {
    private static ProgressDialog progressDialog;

    public BMProgressDialog(Context context) {
        super(context);
    }

    public BMProgressDialog(Context context, int theme) {
        super(context, theme);
    }

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
