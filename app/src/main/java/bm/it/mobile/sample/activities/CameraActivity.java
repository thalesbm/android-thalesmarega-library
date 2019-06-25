package bm.it.mobile.sample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import bm.it.mobile.sample.R;
import bm.it.mobile.ui.activity.BMCameraActivity;

public class CameraActivity extends BMCameraActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        setupToolbar(findViewById(R.id.toolbar));
        setToolbarProperties(getString(R.string.camera_title));

        this.init();
    }

    private void init() {

    }

    private void openCamera() {
        Intent intent = new Intent(this, BMCameraActivity.class);
        startActivityForResult(intent, BMCameraActivity.INTENT_OPEN_CAMERA);
    }
}


