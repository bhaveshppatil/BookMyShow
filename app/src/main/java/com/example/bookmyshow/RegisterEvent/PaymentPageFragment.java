package com.example.bookmyshow.RegisterEvent;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookmyshow.R;


public class PaymentPageFragment extends Fragment implements View.OnClickListener {

    private TextView tvAmazonPay, tvNetBanking, tvUpi, tvCreditCard;
    private Button btnPayAmount, btnDone;
    private LinearLayout layout;
    private Dialog dialog;

    private FragmentCommunication communication;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_payment_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dialog = new Dialog(getContext());
        tvAmazonPay = view.findViewById(R.id.tvAmazonPay);
        tvNetBanking = view.findViewById(R.id.netBanking);
        tvUpi = view.findViewById(R.id.upi);
        btnDone = view.findViewById(R.id.okButton);
        tvCreditCard = view.findViewById(R.id.debitCard);
        btnPayAmount = view.findViewById(R.id.btnPayAmount);
        layout = view.findViewById(R.id.layoutCreditCard);

        tvAmazonPay.setOnClickListener(this);
        tvNetBanking.setOnClickListener(this);
        tvUpi.setOnClickListener(this);
        tvCreditCard.setOnClickListener(this);
        btnPayAmount.setOnClickListener(this);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tvAmazonPay:
            case R.id.netBanking:
            case R.id.upi:
                Toast.makeText(getContext(), "Currently Unavailable", Toast.LENGTH_SHORT).show();
                break;

            case R.id.debitCard:
                layout.setVisibility(View.VISIBLE);
                btnPayAmount.setVisibility(View.VISIBLE);
                break;

            case R.id.btnPayAmount:

                paymentSuccessLayout();
        }
    }

    private void paymentSuccessLayout() {
        dialog.setContentView(R.layout.payment_success);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button okBtn = dialog.findViewById(R.id.okButton);
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}