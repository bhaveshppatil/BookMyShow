package com.example.bookmyshow.Home.cProfile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bookmyshow.Home.HomeActivity;
import com.example.bookmyshow.R;
import com.example.bookmyshow.RegisterEvent.DataHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

public class PurchaseHistoryActivity extends AppCompatActivity {

    private TextView purchaseTitle, purchaseDate, purchaseTime, purchasePrice, purchaseNoOfTickets;
    private ImageView purchaseImage;
    private Button goToMyHome, pBtnRemove, pBtnEdit;
    private ConstraintLayout editCancelConstraintLayout;
    private LinearLayout linearLayout;
    private FirebaseUser user;
    private FirebaseAuth mAuth;
    private String title;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_history);
        initViews();
        editCancelConstraintLayout.setVisibility(View.GONE);
        setPurchaseHistoryDataFromFireBase();
        editCancelConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayout.getVisibility() == View.GONE) {
                    linearLayout.setVisibility(View.VISIBLE);
                } else {
                    linearLayout.setVisibility(View.GONE);
                }
            }
        });
        goToMyHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PurchaseHistoryActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //cancel order

                pBtnRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setCancelPurchaseHistoryDataFromFireBase();
                    }
                });
            }
        }, 5000);

        //edit order

        pBtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void setCancelPurchaseHistoryDataFromFireBase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserData");
        DataHelper dataHelper = new DataHelper("", "", "", "", "", "", "", "", "");
        databaseReference.child(user.getDisplayName()).setValue(dataHelper);
        editCancelConstraintLayout.setAlpha((float) 0.50);
        linearLayout.setVisibility(View.GONE);
    }

    private void setPurchaseHistoryDataFromFireBase() {
        //getting user name
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

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
                title = purchaseDataHelper.getEventName();
                if (title.length() == 0) {
                    if (editCancelConstraintLayout.getVisibility() == View.VISIBLE)
                        editCancelConstraintLayout.setVisibility(View.GONE);
                } else
                    editCancelConstraintLayout.setVisibility(View.VISIBLE);
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
        editCancelConstraintLayout = findViewById(R.id.purchaseHistoryEditCancelConstraintLayout);
        linearLayout = findViewById(R.id.btnShowHide);
        pBtnRemove = findViewById(R.id.btnCancel);
        pBtnEdit = findViewById(R.id.btnEdit);
    }

}