package com.example.bookmyshow.Home.cProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.bookmyshow.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserDetailsActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText userName, userEmail, userMobileNumber;
    private ImageView userImage;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        userName.setText(user.getDisplayName());
        userEmail.setText(user.getEmail());
        userMobileNumber.setText(user.getPhoneNumber());
        Glide.with(userImage).load(user.getPhotoUrl()).into(userImage);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        mAuth = FirebaseAuth.getInstance();
        userName = findViewById(R.id.etUserName);
        userEmail = findViewById(R.id.etUserEmail);
        userMobileNumber = findViewById(R.id.etUserMobileNumber);
        userImage = findViewById(R.id.ivUserImage);
    }
}