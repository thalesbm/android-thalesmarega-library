package bm.it.mobile.sample.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import bm.it.mobile.sample.R;
import bm.it.mobile.ui.activity.BMBaseActivity;

public class MainActivity extends BMBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);

        setupToolbar(findViewById(R.id.toolbar));
        changeToolbarTitle(getString(R.string.title));

        this.init();
    }

    private void init() {
        Button btnValidateCPF = findViewById(R.id.btn_formatter);
        btnValidateCPF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FormatterActivity.class));
            }
        });

        Button btnCamera = findViewById(R.id.btn_camera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CameraActivity.class));
            }
        });

        Button btnGallery = findViewById(R.id.btn_gallery);
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GalleryActivity.class));
            }
        });
    }
}
