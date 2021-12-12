package com.teamBookMyShow.bookmyshow.RegisterEvent;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.teamBookMyShow.bookmyshow.R;

public class EventsDetails extends AppCompatActivity {

    private Spinner spinner;
    private Button btnPayment;
    private FragmentManager fragmentManager;
    private FragmentCommunication communication;
    private TextView tvEventPrice, tvAmount;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_details);

        WebView w = (WebView) findViewById(R.id.webView);
        w.loadUrl("https://in.bookmyshow.com/buytickets/sooryavanshi-hyderabad/movie-hyd-ET00097952-MT/20211105#!seatlayout");
        w.getSettings().setJavaScriptEnabled(true);
        w.setWebViewClient(new WebViewClient());
    }

        /*spinner = findViewById(R.id.spinner);
        btnPayment = findViewById(R.id.btnPayment);

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
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);
        spinner.setAdapter(dataAdapter);
        spinner.setEnabled(true);

        btnPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventsDetails.this, PaymentPage.class);
                startActivity(intent);
            }
        });*/
}