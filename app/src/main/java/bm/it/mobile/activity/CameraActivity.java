package bm.it.mobile.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;

import bm.it.mobile.R;

/**
    // call the activity
    Intent intent = new Intent(getAppActivity(), CameraActivity.class);
    startActivityForResult(intent, CameraActivity.INTENT_OPEN_CAMERA);

    // get result
    if (requestCode == CameraActivity.INTENT_OPEN_CAMERA && resultCode == RESULT_OK) {
        String fileName = data.getExtras().getString(CameraActivity.PARAMETER_IMAGE_PATH);
    }
 */
public class CameraActivity extends CameraGalleryActivity {
    public static final String PARAMETER_IMAGE_PATH = "picturePathImage";
    public static final int INTENT_OPEN_CAMERA = 1000;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPermissionMessage = getString(R.string.permission_gallery);

        mPermissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE};

        if (checkPermissions()) {
            openIntent();
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

    @Override
    protected void openIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri uri = Uri.fromFile(getOutputMediaFile());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, INTENT_OPEN_CAMERA);
    }
}