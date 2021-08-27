package com.example.bookmyshow.Home.cProfile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.bookmyshow.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

public class PurchaseHistoryActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("UserData").child("murali");

    private TextView purchaseTitle, purchaseDate, purchaseTime, purchasePrice, purchaseNoOfTickets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);
        purchaseTitle = findViewById(R.id.tvPurchaseTitle);
        purchaseDate = findViewById(R.id.tvPurchaseDate);
        purchaseTime = findViewById(R.id.tvPurchaseTime);
        purchasePrice = findViewById(R.id.tvPurchasePrice);
        purchaseNoOfTickets = findViewById(R.id.tvPurchaseNoOfTickets);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                GenericTypeIndicator<PurchaseDataHelper> genericTypeIndicator = new GenericTypeIndicator<PurchaseDataHelper>() {
                };
                PurchaseDataHelper dataHelper = snapshot.getValue(genericTypeIndicator);
                purchaseTitle.setText(dataHelper.getEventName());
                purchaseDate.setText(dataHelper.getDate());
                purchaseTime.setText(dataHelper.getTime());
                purchasePrice.setText("₹ "+dataHelper.getPrice());
                purchaseNoOfTickets.setText(dataHelper.getTicketQuantity());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}