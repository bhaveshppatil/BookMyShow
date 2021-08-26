package com.example.bookmyshow.RegisterEvent;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookmyshow.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegistrationFragment extends Fragment {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String date, quantity, price;
    private Button btnNextContact;
    private EditText etName, etEmail, etContact;
    private FragmentCommunication communication;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            date = getArguments().getString("date");
            quantity = getArguments().getString("quantity");
            price = getArguments().getString("ticketPrice");

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnNextContact = view.findViewById(R.id.btnNextContact);

        etEmail = view.findViewById(R.id.etEmail);
        etContact = view.findViewById(R.id.etContact);
        etName = view.findViewById(R.id.etName);

        btnNextContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("UserData");

                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String contactNum = etContact.getText().toString();
                String eventName = "FrontRow Open Mics";
                String time = "4:30 PM";
                date = getArguments().getString("date");
                quantity = getArguments().getString("quantity");
                price = getArguments().getString("ticketPrice");

                if (name.length() >= 1 && email.matches(emailPattern) && contactNum.length() == 10) {
                    DataHelper dataHelper = new DataHelper(name, email, contactNum, eventName, date, time, quantity, price);
                    databaseReference.child(name).setValue(dataHelper);
                    communication.launchRegistrationFrag(bundle);

                } else {
                    Toast.makeText(getContext(), "Please check information again", Toast.LENGTH_SHORT).show();
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