package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView countText = findViewById(R.id.countText);
        Button clickButton = findViewById(R.id.clickButton);

        clickButton.setOnClickListener(v -> {
            count++;
            countText.setText(String.valueOf(count));
        });
    }
}