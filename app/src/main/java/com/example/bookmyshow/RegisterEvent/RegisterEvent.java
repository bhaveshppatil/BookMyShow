package com.example.bookmyshow.RegisterEvent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookmyshow.R;


public class RegisterEvent extends AppCompatActivity {

    private Button btnRegister, btnInterested;
    private TextView tvLike, tvShowTerms;
    private ImageView ivTermsArrow;
    private int countLike = 21;
    private int termsCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_event);

        btnInterested = findViewById(R.id.btnInterested);
        btnRegister = findViewById(R.id.btnRegister);
        tvLike = findViewById(R.id.tvLike);
        tvShowTerms = findViewById(R.id.tvShowTerms);
        ivTermsArrow = findViewById(R.id.ivTermsConditions);

        tvLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countLike = countLike + 1;
                if (countLike == 21) {
                    //first time clicked to do this
                    Toast.makeText(getApplicationContext(), "Button clicked first time!", Toast.LENGTH_LONG).show();
                } else {
                    //check how many times clicked and so on
                    tvLike.setText(countLike + "");
                }
            }
        });

        btnInterested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterEvent.this, "Thank You For Showing Interest " + R.drawable.ic_baseline_thumb_up_24, Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterEvent.this, SelectDate.class);
                startActivity(intent);
            }
        });

        ivTermsArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                termsCount = termsCount + 1;
                if (termsCount % 2 == 0) {
                    tvShowTerms.setVisibility(View.GONE);
                }else {
                    tvShowTerms.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
