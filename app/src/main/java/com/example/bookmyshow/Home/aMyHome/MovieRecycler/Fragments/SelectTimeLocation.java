package com.example.bookmyshow.Home.aMyHome.MovieRecycler.Fragments;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class SelectTimeLocation extends AppCompatActivity implements ClickListener {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private List<TheaterLocationModel> theaterTimeModels = new ArrayList<>();
    private RecyclerView recyclerView;
    private int mYear, mMonth, mDay;
    private Button btnDate, btnProceed;
    private EditText etDate;
    private CardView recyclerViewCard;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time_location);

        recyclerView = findViewById(R.id.timeTheaterRecyclerView);
        btnDate = findViewById(R.id.btnMovieDate);
        etDate = findViewById(R.id.etMovieDate);
        recyclerViewCard = findViewById(R.id.recyclerViewCard);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Date
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("Ticket");

                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(SelectTimeLocation.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                etDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                recyclerViewCard.setVisibility(View.VISIBLE);

                                databaseReference.child("Ticket").setValue(etDate.getText().toString());

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        buildTimeLocationData();
        setRecyclerView();
    }

    private void buildTimeLocationData() {
        theaterTimeModels.add(new TheaterLocationModel("01:05 PM", "04:15 PM", "Prasads: Hyderabad"));
        theaterTimeModels.add(new TheaterLocationModel("02:45 PM", "05:30 PM", "Miraj Cinemas: Shalini Shivani, Hyderabad"));
        theaterTimeModels.add(new TheaterLocationModel("12:05 PM", "03:15 PM", "PVR: Irrum Manzil, Hyderabad"));
        theaterTimeModels.add(new TheaterLocationModel("03:05 PM", "06:15 PM", "PVR Forum Sujana Mall: Kukatpally, Hyderabad"));
        theaterTimeModels.add(new TheaterLocationModel("02:45 PM", "03:00 PM", "PVR: Next Galleria Mall, Panjagutta"));
        theaterTimeModels.add(new TheaterLocationModel("01:30 PM", "04:00 PM", "INOX: Maheshwari"));
        theaterTimeModels.add(new TheaterLocationModel("09:05 PM", "11:15 PM", "Platinum Movietime: Gachibowli"));
        theaterTimeModels.add(new TheaterLocationModel("04:05 PM", "06:15 PM", "Cinepolis: Sudha Cinemas, Hyderabad"));
        theaterTimeModels.add(new TheaterLocationModel("03:05 PM", "05:00 PM", "AMB Cinemas: Gachibowli"));
        theaterTimeModels.add(new TheaterLocationModel("11:05 AM", "01:15 PM", "Asian Cineplanet Multiplex: Kompally"));
        theaterTimeModels.add(new TheaterLocationModel("07:05 PM", "10:15 PM", "Carnival: Ameerpet"));

    }

    private void setRecyclerView() {
        TheaterAdapter theaterAdapter = new TheaterAdapter(theaterTimeModels, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(theaterAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onItemClick(TheaterLocationModel locationModel) {

        TermsAndConditionFragment termsAndConditionFragment = new TermsAndConditionFragment();
        termsAndConditionFragment.show(getSupportFragmentManager(), "TermsAndCondition");

    }
}

