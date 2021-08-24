package com.example.bookmyshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SelectLanguage extends AppCompatActivity {
    private Button btnStarted;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        btnStarted = findViewById(R.id.btnStarted);

        btnStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectLanguage.this, LoginScreen.class);
                startActivity(intent);
            }
        });
    }
}