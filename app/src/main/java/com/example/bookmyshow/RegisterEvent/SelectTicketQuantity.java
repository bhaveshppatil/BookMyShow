package com.example.bookmyshow.RegisterEvent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.bookmyshow.R;

public class SelectTicketQuantity extends Fragment {

    private ImageView ivAddTicket, ivRemoveTicket;
    private TextView tvTicketPrice, tvQuantity;
    private Button btnProceed;
    private int addTicket = 1;
    private int removeTicket = 1;
    private int ticketPrice = 699;

    private FragmentManager fragmentManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_ticket_quantuty, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvTicketPrice = view.findViewById(R.id.tvPrice);
        tvQuantity = view.findViewById(R.id.tvQuantity);
        ivAddTicket = view.findViewById(R.id.ivAdd);
        ivRemoveTicket = view.findViewById(R.id.ivMinus);

        ivAddTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addTicket == 10) {
                    Toast.makeText(getContext(), "No more ticket available", Toast.LENGTH_SHORT).show();
                }
                addTicket = addTicket + 1;
                tvQuantity.setText(addTicket + "");
                tvTicketPrice.setText("₹ " + ticketPrice * addTicket);
            }
        });

        ivRemoveTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeTicket = removeTicket - 1;
                int currentItem = Integer.parseInt(tvQuantity.getText().toString());
                Toast.makeText(getContext(), "Ticket removed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}