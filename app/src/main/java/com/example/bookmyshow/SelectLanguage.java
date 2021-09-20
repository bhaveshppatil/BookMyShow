package com.example.bookmyshow;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookmyshow.Home.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SelectLanguage extends AppCompatActivity {

    private Button btnStarted;
    private FirebaseAuth mAuth;
    private FirebaseAuth firebaseAuth;
    private RadioButton english, hindi, marathi, tamil, kannada, telugu, malayalam;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            Intent intent = new Intent(SelectLanguage.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_language);
        mAuth = FirebaseAuth.getInstance();
        btnStarted = findViewById(R.id.btnStarted);
        english = findViewById(R.id.english);
        hindi = findViewById(R.id.hindi);
        malayalam = findViewById(R.id.malayalam);
        marathi = findViewById(R.id.marathi);
        telugu = findViewById(R.id.telugu);
        kannada = findViewById(R.id.kannada);
        tamil = findViewById(R.id.tamil);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.english:
                        Toast.makeText(SelectLanguage.this, "English Language Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.hindi:
                        Toast.makeText(SelectLanguage.this, "Hindi Language Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.marathi:
                        Toast.makeText(SelectLanguage.this, "Marathi Language Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tamil:
                        Toast.makeText(SelectLanguage.this, "Tamil Language Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.telugu:
                        Toast.makeText(SelectLanguage.this, "Telugu Language Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.kannada:
                        Toast.makeText(SelectLanguage.this, "Kannada Language Selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.malayalam:
                        Toast.makeText(SelectLanguage.this, "Malayalam Language Selected", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        btnStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SelectLanguage.this, LoginScreen.class);
                startActivity(intent);
            }
        });
    }
}