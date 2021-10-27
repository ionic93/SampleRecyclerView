package com.example.samplerecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PersonCardView extends AppCompatActivity {
    TextView textName, textMobile;
    public static final String KEY_SIMPLE_DATA = "item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_card_view);
        textName = findViewById(R.id.textName);
        textMobile = findViewById(R.id.textMobile);
        Intent intent = getIntent();
        processIntent(intent);
    }

    public void goBack(View view) {
        finish();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    private void processIntent(Intent intent) {
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            Person data = bundle.getParcelable(KEY_SIMPLE_DATA);
            if (data != null) {
                textName.setText(data.getName());
                textMobile.setText(data.getMobile());
            }
        }
    }
}