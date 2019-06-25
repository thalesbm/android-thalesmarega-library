package bm.it.mobile.sample.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import bm.it.mobile.sample.R;
import bm.it.mobile.ui.activity.BMBaseActivity;
import bm.it.mobile.ui.activity.BMGalleryActivity;

public class GalleryActivity extends BMBaseActivity {

    private ImageView imageView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        setupToolbar(findViewById(R.id.toolbar));
        setToolbarProperties(getString(R.string.gallery_title));

        this.init();
    }

    private void init() {
        imageView = findViewById(R.id.activity_gallery_imageview);

        Button btnOpenCamera = findViewById(R.id.activity_gallery_button);
        btnOpenCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCamera();
            }
        });
    }

    private void openCamera() {
        Intent intent = new Intent(this, BMGalleryActivity.class);
        startActivityForResult(intent, BMGalleryActivity.INTENT_OPEN_GALLERY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == BMGalleryActivity.INTENT_OPEN_GALLERY
                && resultCode == RESULT_OK
                && data != null && data.getExtras() != null) {
            String fileName = data.getExtras().getString(BMGalleryActivity.PARAMETER_IMAGE_PATH);

            // TODO: EXIBIR A IMAGEM
        }
    }
}


