package com.example.bookmyshow.RegisterEvent;

import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.bookmyshow.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class SelectDateTime extends Fragment {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private Button btnDate, btnProceed;
    private EditText etDate;
    private LinearLayout layout;
    private CardView crdTime1, crdTime2, crdTime3;
    private TextView tvTime1, tvTime2, tvTime3;
    private FragmentCommunication communication;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_date_time, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnDate = view.findViewById(R.id.btnDate);
        etDate = view.findViewById(R.id.etDate);

        crdTime1 = view.findViewById(R.id.crdTime1);
        crdTime2 = view.findViewById(R.id.crdTime2);
        crdTime3 = view.findViewById(R.id.crdTime3);

        tvTime1 = view.findViewById(R.id.tvTime1);
        tvTime2 = view.findViewById(R.id.tvTime2);
        tvTime3 = view.findViewById(R.id.tvTime3);

        btnProceed = view.findViewById(R.id.btnProceedDate);
        layout = view.findViewById(R.id.layoutSelectTime);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get Current Date
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                layout.setVisibility(View.VISIBLE);

                                etDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                                crdTime1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        crdTime1.setCardBackgroundColor(ContextCompat.getColor(crdTime1.getContext(), R.color.light_red));
                                        tvTime1.setTextColor(ContextCompat.getColor(tvTime1.getContext(), R.color.white));
                                    }
                                });

                                crdTime2.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        crdTime2.setCardBackgroundColor(ContextCompat.getColor(crdTime2.getContext(), R.color.light_red));
                                        tvTime2.setTextColor(ContextCompat.getColor(tvTime2.getContext(), R.color.white));

                                    }
                                });

                                crdTime3.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        crdTime3.setCardBackgroundColor(ContextCompat.getColor(crdTime3.getContext(), R.color.light_red));
                                        tvTime3.setTextColor(ContextCompat.getColor(tvTime3.getContext(), R.color.white));
                                    }
                                });
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

/*
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                etTime.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        });

 */

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                String date = etDate.getText().toString();
                bundle.putString("date", date);

                if (communication != null) {
                    communication.launchSelectTicketFrag(bundle);
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        communication = (FragmentCommunication) context;
    }
}