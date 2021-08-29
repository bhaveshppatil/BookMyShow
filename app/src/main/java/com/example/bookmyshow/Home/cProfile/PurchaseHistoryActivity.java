package com.example.bookmyshow.Home.cProfile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

    private TextView purchaseTitle, movieTitle, purchaseDate, movieDate, purchaseTime, movieTime, purchasePrice, moviePrice, purchaseNoOfTickets, movieNoOfTickets;
    private EditText updateEventDate, updateEventTime, updateEventNoOfTickets;
    private ImageView purchaseImage, movieImage;
    private Button goToMyHome, pBtnRemove, pBtnEdit, movieCancel, movieEdit, updateEvent;
    private ConstraintLayout eventEditCancelConstraintLayout, movieEditCancelConstraintLayout;
    private LinearLayout eventLinearLayout, movieLinearLayout, editEventLinearLayout;
    private FirebaseUser user;
    private FirebaseAuth mAuth;
    private String title, mTitle, eventImage, eName, eEmail, eContactNo, stp;
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
        movieEditCancelConstraintLayout.setVisibility(View.GONE);
        eventEditCancelConstraintLayout.setVisibility(View.GONE);
        setPurchaseHistoryDataFromFireBase();
        movieEditCancelConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (movieLinearLayout.getVisibility() == View.GONE) {
                    movieLinearLayout.setVisibility(View.VISIBLE);
                } else {
                    movieLinearLayout.setVisibility(View.GONE);
                }
            }
        });
        eventEditCancelConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (eventLinearLayout.getVisibility() == View.GONE) {
                    eventLinearLayout.setVisibility(View.VISIBLE);
                } else {
                    eventLinearLayout.setVisibility(View.GONE);
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

        //event cancel
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

        //edit event
        pBtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventLinearLayout.setVisibility(View.GONE);
                editEventLinearLayout.setVisibility(View.VISIBLE);
                goToMyHome.setVisibility(View.GONE);
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
                        updateEventTime.setText(purchaseDataHelper.getTime());
                        updateEventDate.setText(purchaseDataHelper.getDate());
                        updateEventNoOfTickets.setText(purchaseDataHelper.getTicketQuantity());
                        updateEvent.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                setEditEventPurchaseHistoryDataFromFireBase();
                                editEventLinearLayout.setVisibility(View.GONE);
                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        });
        // cancel Movie
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //cancel order

                movieCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setCancelMoviePurchaseHistoryDataFromFireBase();
                    }
                });
            }
        }, 5000);

        //edit movie
        movieEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    //set edit data
    private void setEditEventPurchaseHistoryDataFromFireBase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserData");
        String eventUDate = updateEventDate.getText().toString();
        String eventUTime = updateEventTime.getText().toString();
        String eventUNoOfTickets = updateEventNoOfTickets.getText().toString();
        int tp = Integer.parseInt(stp);
        String sn = purchaseNoOfTickets.getText().toString();
        int n = Integer.parseInt(sn);
        int cn = Integer.parseInt(eventUNoOfTickets);
        int eventPrice = (tp / n) * cn;
        String ePrice = String.valueOf(eventPrice);
        DataHelper dataHelper2 = new DataHelper(eName, eEmail, eContactNo, purchaseTitle.getText().toString(), eventUDate, eventUTime, eventUNoOfTickets, ePrice, eventImage);
        databaseReference.child(user.getDisplayName()).setValue(dataHelper2);
    }

    private void setCancelMoviePurchaseHistoryDataFromFireBase() {
    }

    private void setCancelPurchaseHistoryDataFromFireBase() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("UserData");
        DataHelper dataHelper = new DataHelper("", "", "", "", "", "", "", "", "");
        databaseReference.child(user.getDisplayName()).setValue(dataHelper);
        eventEditCancelConstraintLayout.setAlpha((float) 0.50);
        eventLinearLayout.setVisibility(View.GONE);
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
                eName = purchaseDataHelper.getName();
                eEmail = purchaseDataHelper.getEmail();
                eContactNo = purchaseDataHelper.getContact();
                purchaseTitle.setText(purchaseDataHelper.getEventName());
                purchaseDate.setText(purchaseDataHelper.getDate());
                purchaseTime.setText(purchaseDataHelper.getTime());
                purchasePrice.setText("₹ " + purchaseDataHelper.getPrice());
                stp = purchaseDataHelper.getPrice();
                purchaseNoOfTickets.setText(purchaseDataHelper.getTicketQuantity());
                eventImage = purchaseDataHelper.getImageUrl();
                Glide.with(purchaseImage).load(purchaseDataHelper.getImageUrl()).into(purchaseImage);
                title = purchaseDataHelper.getEventName();
                if (title.length() == 0) {
                    if (eventEditCancelConstraintLayout.getVisibility() == View.VISIBLE)
                        eventEditCancelConstraintLayout.setVisibility(View.GONE);
                } else
                    eventEditCancelConstraintLayout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
/*
        FirebaseDatabase database1 = FirebaseDatabase.getInstance();
        DatabaseReference myRef2 = database1.getReference("Ticket");
        mTitle = String.valueOf(myRef2.child("Movie").get());
        movieTitle.setText((CharSequence) myRef2.child("Movie"));
        moviePrice.setText((CharSequence) myRef2.child("Total Price"));
        movieNoOfTickets.setText((CharSequence) myRef2.child("Seat Quantity"));
        movieDate.setText((CharSequence) myRef2.child("Ticket"));
        if (mTitle.length() == 0) {
            if (movieEditCancelConstraintLayout.getVisibility() == View.VISIBLE)
                movieEditCancelConstraintLayout.setVisibility(View.GONE);
        } else
            movieEditCancelConstraintLayout.setVisibility(View.VISIBLE);
*/
    }

    /*private void setMovieHistory() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Ticket");
        mTitle = String.valueOf(myRef.child("Movie"));
        movieTitle.setText((CharSequence) myRef.child("Movie"));
        moviePrice.setText((CharSequence) myRef.child("Total Price"));
        movieNoOfTickets.setText((CharSequence) myRef.child("Seat Quantity"));
        movieDate.setText((CharSequence) myRef.child("Ticket"));
        if (mTitle.length() == 0) {
            if (movieEditCancelConstraintLayout.getVisibility() == View.VISIBLE)
                movieEditCancelConstraintLayout.setVisibility(View.GONE);
        } else
            movieEditCancelConstraintLayout.setVisibility(View.VISIBLE);
    }*/

    private void initViews() {
        purchaseTitle = findViewById(R.id.tvPurchaseTitle);
        purchaseDate = findViewById(R.id.tvPurchaseDate);
        purchaseTime = findViewById(R.id.tvPurchaseTime);
        purchasePrice = findViewById(R.id.tvPurchasePrice);
        purchaseNoOfTickets = findViewById(R.id.tvPurchaseNoOfTickets);
        purchaseImage = findViewById(R.id.ivPurchaseImage);
        goToMyHome = findViewById(R.id.btnGoToMyHome);
        eventEditCancelConstraintLayout = findViewById(R.id.purchaseHistoryEditCancelConstraintLayout);
        eventLinearLayout = findViewById(R.id.btnShowHide);
        pBtnRemove = findViewById(R.id.btnCancel);
        pBtnEdit = findViewById(R.id.btnEdit);
        editEventLinearLayout = findViewById(R.id.editEventLinearLayout);

        movieEditCancelConstraintLayout = findViewById(R.id.moviePurchaseHistoryEditCancelConstraintLayout);
        movieLinearLayout = findViewById(R.id.btnMovieShowHide);
        movieTitle = findViewById(R.id.tvMoviePurchaseTitle);
        movieDate = findViewById(R.id.tvMoviePurchaseDate);
        movieTime = findViewById(R.id.tvMoviePurchaseTime);
        moviePrice = findViewById(R.id.tvMoviePurchasePrice);
        movieNoOfTickets = findViewById(R.id.tvMoviePurchaseNoOfTickets);
        movieImage = findViewById(R.id.ivMoviePurchaseImage);
        movieCancel = findViewById(R.id.btnMovieCancel);
        movieEdit = findViewById(R.id.btnMovieEdit);

        updateEventDate = findViewById(R.id.updateEventDate);
        updateEventTime = findViewById(R.id.updateEventTime);
        updateEventNoOfTickets = findViewById(R.id.updateEventNoOfTickets);
        updateEvent = findViewById(R.id.btnUpdateEvent);
    }

}