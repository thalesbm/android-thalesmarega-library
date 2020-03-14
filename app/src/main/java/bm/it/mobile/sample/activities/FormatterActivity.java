package bm.it.mobile.sample.activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.widget.EditText;

import bm.it.mobile.formatter.Mask;
import bm.it.mobile.sample.R;
import bm.it.mobile.ui.activity.BMBaseActivity;

public class FormatterActivity extends BMBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formatter_layout);

        setupToolbar(findViewById(R.id.toolbar));
        setToolbarProperties(getString(R.string.formatter_title));

        this.phoneFormatter();
        this.cepFormatter();
        this.dateFormatter();
        this.cpfFormatter();
        this.rgFormatter();
    }

    private void phoneFormatter() {
        EditText editText = findViewById(R.id.activity_formatter_phone);
        Mask mask = new Mask(Mask.FORMAT_PHONE);
        editText.addTextChangedListener(mask.insert(editText));
    }

    private void cepFormatter() {
        EditText editText = findViewById(R.id.activity_formatter_cep);
        Mask mask = new Mask(Mask.FORMAT_CEP);
        editText.addTextChangedListener(mask.insert(editText));
    }

    private void dateFormatter() {
        EditText editText = findViewById(R.id.activity_formatter_date);
        Mask mask = new Mask(Mask.FORMAT_DATE);
        editText.addTextChangedListener(mask.insert(editText));
    }

    private void rgFormatter() {
        EditText editText = findViewById(R.id.activity_formatter_rg);
        Mask mask = new Mask(Mask.FORMAT_RG);
        editText.addTextChangedListener(mask.insert(editText));
    }

    private void cpfFormatter() {
        EditText editText = findViewById(R.id.activity_formatter_cpf);
        Mask mask = new Mask(Mask.FORMAT_CPF);
        editText.addTextChangedListener(mask.insert(editText));
    }
}
