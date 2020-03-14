package bm.it.mobile.sample.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import bm.it.mobile.sample.R;
import bm.it.mobile.ui.activity.BMBaseActivity;
import bm.it.mobile.ui.activity.BMCameraActivity;
import bm.it.mobile.utils.BMImageUtils;

public class CameraActivity extends BMBaseActivity {

    private ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        setupToolbar(findViewById(R.id.toolbar));
        setToolbarProperties(getString(R.string.camera_title));

        this.init();
    }

    private void init() {
        imageView = findViewById(R.id.activity_camera_imageview);

        Button btnOpenCamera = findViewById(R.id.activity_camera_button);
        btnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });
    }

    private void openCamera() {
        Intent intent = new Intent(this, BMCameraActivity.class);
        startActivityForResult(intent, BMCameraActivity.INTENT_OPEN_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == BMCameraActivity.INTENT_OPEN_CAMERA
                && resultCode == RESULT_OK
                && data != null && data.getExtras() != null) {
            String fileName = data.getExtras().getString(BMCameraActivity.PARAMETER_IMAGE_PATH);

            BMImageUtils imageUtils = new BMImageUtils(this);
            imageView.setImageBitmap(imageUtils.toBitmap().fromImagePath(fileName));
        }
    }
}


