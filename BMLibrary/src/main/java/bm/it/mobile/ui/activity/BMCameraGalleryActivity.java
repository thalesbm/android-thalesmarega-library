package bm.it.mobile.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bm.it.mobile.R;
import bm.it.mobile.utils.BMFolderUtils;

public abstract class BMCameraGalleryActivity extends BMBaseActivity {

    protected final int MULTIPLE_PERMISSIONS = 100;

    protected String[] mPermissions;

    protected String mFileName, mCompletePath, mPermissionMessage;

    protected abstract void openIntent();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFileName = String.valueOf(new Date().getTime());
    }

    protected boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : mPermissions) {
            result = ContextCompat.checkSelfPermission(this, p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    protected void alertDialogPermissionIssue() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(getString(R.string.alert));
        alertDialogBuilder.setMessage(mPermissionMessage);
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton(getString(R.string.try_again), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                checkPermissions();
            }
        });

        alertDialogBuilder.setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @Nullable String permissions[], @Nullable int[] grantResults) {
        switch (requestCode) {
            case MULTIPLE_PERMISSIONS: {
                if (grantResults != null && grantResults.length > 0) {
                    boolean allPermissionHasBeenGranted = false;
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                            allPermissionHasBeenGranted = true;
                        } else {
                            allPermissionHasBeenGranted = false;
                            break;
                        }
                    }
                    if (allPermissionHasBeenGranted) {
                        openIntent();
                    } else {
                        alertDialogPermissionIssue();
                    }
                }
            }
        }
    }

    protected File getOutputMediaFile() {
        try {
            BMFolderUtils folderUtils = new BMFolderUtils(this);
            mCompletePath = folderUtils.getFile().getAbsolutePath() + "/" + mFileName + ".png";
            return new File(folderUtils.getFile().getAbsolutePath(), mFileName + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
