package bm.it.mobile.activity;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.io.InputStream;

import bm.it.mobile.R;
import bm.it.mobile.util.ImageUtils;

/**
     // call the activity
     Intent intent = new Intent(getAppActivity(), GalleryActivity.class);
     startActivityForResult(intent, GalleryActivity.INTENT_OPEN_GALLERY);

     // get result
     if (requestCode == CameraActivity.INTENT_OPEN_CAMERA && resultCode == RESULT_OK) {
        String fileName = data.getExtras().getString(CameraActivity.PARAMETER_IMAGE_PATH);
     }
 */
public class GalleryActivity extends CameraGalleryActivity {
    public static final String PARAMETER_IMAGE_PATH = "picturePathImage";
    public static final int INTENT_OPEN_GALLERY = 1001;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPermissionMessage = getString(R.string.permission_gallery);

        mPermissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE};

        if (checkPermissions()) {
            openIntent();
        }
    }

    @Override
    protected void openIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, INTENT_OPEN_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == INTENT_OPEN_GALLERY && resultCode == RESULT_OK) {
            if (data != null) {
                try {
                    final Uri imageUri = data.getData();
                    final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                    final Bitmap bitmap = BitmapFactory.decodeStream(imageStream);

                    ImageUtils imageUtils = new ImageUtils(this);
                    imageUtils.toBitmap().saveBitmapInFile(bitmap, getOutputMediaFile());

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra(PARAMETER_IMAGE_PATH, mCompletePath);
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                    setResult(Activity.RESULT_CANCELED, new Intent());
                    finish();
                }
            }
        } else if (requestCode == INTENT_OPEN_GALLERY && resultCode == RESULT_CANCELED) {
            setResult(Activity.RESULT_CANCELED, new Intent());
            finish();
        }
    }
}
