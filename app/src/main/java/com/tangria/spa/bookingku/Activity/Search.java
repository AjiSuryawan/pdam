package com.tangria.spa.bookingku.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.tangria.spa.bookingku.R;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class Search extends AppCompatActivity {

    private MaterialBetterSpinner spinner;
    private static final String[] periodList = new String[]{"Blok", "Nama", "RT"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        spinner = findViewById(R.id.android_material_design_spinner);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, periodList);
        spinner.setAdapter(arrayAdapter);

        Button updateBtn=(Button)findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
