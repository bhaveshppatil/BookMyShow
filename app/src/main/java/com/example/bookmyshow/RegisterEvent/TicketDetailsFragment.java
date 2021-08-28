package com.example.bookmyshow.RegisterEvent;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookmyshow.R;

import java.util.ArrayList;
import java.util.List;


public class TicketDetailsFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private Button btnPayment;
    private FragmentCommunication communication;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ticket_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spinner = view.findViewById(R.id.spinner);
        btnPayment = view.findViewById(R.id.btnPayment);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Andhra Pradesh");
        categories.add("Arunachal Pradesh");
        categories.add("Assam");
        categories.add("Bihar");
        categories.add("Chhattisgarh");
        categories.add("Goa");
        categories.add("Gujarat");
        categories.add("Haryana");
        categories.add("Himachal Pradesh");
        categories.add("Madhya Pradesh");
        categories.add("Maharashtra");
        categories.add("Odisha");
        categories.add("Punjab");
        categories.add("Telangana");
        categories.add("Uttar Pradesh");
        categories.add("Uttarakhand");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, categories);
        spinner.setAdapter(dataAdapter);
        spinner.setEnabled(true);

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                if (communication != null) {
                    communication.launchPaymentFrag(bundle);
                }

            }
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        communication = (FragmentCommunication) context;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}