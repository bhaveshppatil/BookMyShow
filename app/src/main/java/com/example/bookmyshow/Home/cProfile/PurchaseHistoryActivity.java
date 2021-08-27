package com.example.bookmyshow.Home.cProfile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bookmyshow.Home.HomeActivity;
import com.example.bookmyshow.Home.aMyHome.HomeFragment;
import com.example.bookmyshow.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

public class PurchaseHistoryActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;


    private TextView purchaseTitle, purchaseDate, purchaseTime, purchasePrice, purchaseNoOfTickets;
    private ImageView purchaseImage;
    private Button goToMyHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);
        initViews();
        setPurchaseHistoryDataFromFireBase();
        goToMyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PurchaseHistoryActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setPurchaseHistoryDataFromFireBase() {
        //getting user name
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("UserData").child(user.getDisplayName());

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<PurchaseDataHelper> genericTypeIndicator = new GenericTypeIndicator<PurchaseDataHelper>() {
                };
                PurchaseDataHelper purchaseDataHelper = snapshot.getValue(genericTypeIndicator);
                purchaseTitle.setText(purchaseDataHelper.getEventName());
                purchaseDate.setText(purchaseDataHelper.getDate());
                purchaseTime.setText(purchaseDataHelper.getTime());
                purchasePrice.setText("₹ " + purchaseDataHelper.getPrice());
                purchaseNoOfTickets.setText(purchaseDataHelper.getTicketQuantity());
                Glide.with(purchaseImage).load(purchaseDataHelper.getImageUrl()).into(purchaseImage);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initViews() {
        purchaseTitle = findViewById(R.id.tvPurchaseTitle);
        purchaseDate = findViewById(R.id.tvPurchaseDate);
        purchaseTime = findViewById(R.id.tvPurchaseTime);
        purchasePrice = findViewById(R.id.tvPurchasePrice);
        purchaseNoOfTickets = findViewById(R.id.tvPurchaseNoOfTickets);
        purchaseImage = findViewById(R.id.ivPurchaseImage);
        goToMyHome = findViewById(R.id.btnGoToMyHome);
    }

}