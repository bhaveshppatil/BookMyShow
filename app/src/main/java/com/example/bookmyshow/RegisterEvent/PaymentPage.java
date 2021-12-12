package com.example.bookmyshow.RegisterEvent;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookmyshow.Home.cProfile.PurchaseHistoryActivity;
import com.example.bookmyshow.R;

public class PaymentPage extends AppCompatActivity implements View.OnClickListener {

    private TextView tvAmazonPay, tvNetBanking, tvUpi, tvCreditCard;
    private Button btnPayAmount, btnDone;
    private LinearLayout layout;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_page);
        dialog = new Dialog(this);
        initViews();
    }

    private void initViews() {
        tvAmazonPay = findViewById(R.id.tvAmazonPay);
        tvNetBanking = findViewById(R.id.netBanking);
        tvUpi = findViewById(R.id.upi);
        btnDone = findViewById(R.id.okButton);
        tvCreditCard = findViewById(R.id.debitCard);
        btnPayAmount = findViewById(R.id.btnPayAmount);
        layout = findViewById(R.id.layoutCreditCard);

        tvAmazonPay.setOnClickListener(this);
        tvNetBanking.setOnClickListener(this);
        tvUpi.setOnClickListener(this);
        tvCreditCard.setOnClickListener(this);
        btnPayAmount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tvAmazonPay:
            case R.id.netBanking:
            case R.id.upi:
                Toast.makeText(PaymentPage.this, "Currently Unavailable", Toast.LENGTH_SHORT).show();
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
                Intent intent = new Intent(PaymentPage.this, PurchaseHistoryActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();
    }
}