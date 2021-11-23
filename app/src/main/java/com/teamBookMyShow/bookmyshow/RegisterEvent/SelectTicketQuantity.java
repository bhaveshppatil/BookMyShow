package com.teamBookMyShow.bookmyshow.RegisterEvent;

import android.content.Context;
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

import com.teamBookMyShow.bookmyshow.R;

public class SelectTicketQuantity extends Fragment {

    private ImageView ivAddTicket, ivRemoveTicket;
    private TextView tvTicketPrice, tvQuantity;
    private Button btnProceed;
    private int addTicket = 1, removeTicket = 1, ticketPrice = 699, realPrice;
    private FragmentCommunication communication;
    private String date;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            date = getArguments().getString("date");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_ticket_quantuty, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);

        ivAddTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addTicket == 10) {
                    Toast.makeText(getContext(), "No more ticket available", Toast.LENGTH_SHORT).show();
                }
                addTicket = addTicket + 1;
                tvQuantity.setText(addTicket + "");
                realPrice = ticketPrice * addTicket;
                tvTicketPrice.setText("₹ " + realPrice);
            }
        });

        ivRemoveTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeTicket = addTicket - 1;
                tvQuantity.setText(removeTicket + "");
                tvTicketPrice.setText("₹ " + (realPrice - ticketPrice));

                if (realPrice == 699 && addTicket == 1) {
                    Toast.makeText(getContext(), "You can't remove ticket", Toast.LENGTH_SHORT).show();
                } else {
                    addTicket--;
                    realPrice = realPrice - ticketPrice;
                }
            }
        });

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                date = getArguments().getString("date");
                bundle.putString("date", date);
                bundle.putString("quantity", String.valueOf(addTicket));
                bundle.putString("ticketPrice", String.valueOf(ticketPrice * addTicket));

                if (communication != null) {
                    communication.launchContactDetails(bundle);
                }
            }
        });
    }

    private void initViews(View view) {
        tvTicketPrice = view.findViewById(R.id.tvPrice);
        tvQuantity = view.findViewById(R.id.tvQuantity);
        ivAddTicket = view.findViewById(R.id.ivAdd);
        ivRemoveTicket = view.findViewById(R.id.ivMinus);
        btnProceed = view.findViewById(R.id.btnProceedTicket);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        communication = (FragmentCommunication) context;
    }

}