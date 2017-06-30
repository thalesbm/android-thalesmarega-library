package bm.it.mobile.activity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bm.it.mobile.R;
import bm.it.mobile.util.FolderUtils;

/**
    // call the activity
    Intent intent = new Intent(getAppActivity(), CameraActivity.class);
    startActivityForResult(intent, CameraActivity.INTENT_OPEN_CAMERA);

    // get result
    if (requestCode == CameraActivity.INTENT_OPEN_CAMERA && resultCode == RESULT_OK) {
        String fileName = data.getExtras().getString(CameraActivity.PARAMETER_IMAGE_PATH);
    }
 */
public class CameraActivity extends BMBaseActivity {
    public static final String PARAMETER_IMAGE_PATH = "picturePathImage";
    public static final int INTENT_OPEN_CAMERA = 1000;

    private final int MULTIPLE_PERMISSIONS = 100;

    private String mFileName, mCompletePath;

    private String[] permissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFileName = String.valueOf(new Date().getTime());

        if (checkPermissions()) {
            takePicture();
        }
    }

    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissions) {
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
                        takePicture();
                    } else {
                        alertDialogPermissionIssue();
                    }
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == INTENT_OPEN_CAMERA && resultCode == RESULT_OK) {
            Intent returnIntent = new Intent();
            returnIntent.putExtra(PARAMETER_IMAGE_PATH, mCompletePath);
            setResult(Activity.RESULT_OK, returnIntent);
            finish();
        } else if (requestCode == INTENT_OPEN_CAMERA && resultCode == RESULT_CANCELED) {
            finish();
        }
    }

    private void takePicture() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri uri = Uri.fromFile(getOutputMediaFile());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, INTENT_OPEN_CAMERA);
    }

    private File getOutputMediaFile() {
        try {
            FolderUtils folderUtils = new FolderUtils(this);
            mCompletePath = folderUtils.getFile().getAbsolutePath() + "/" + mFileName + ".png";
            return new File(folderUtils.getFile().getAbsolutePath(), mFileName + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void alertDialogPermissionIssue() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(getString(R.string.alert));
        alertDialogBuilder.setMessage(getString(R.string.permission_camera));
        alertDialogBuilder.setCancelable(false);
        alertDialogBuilder.setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                checkPermissions();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}