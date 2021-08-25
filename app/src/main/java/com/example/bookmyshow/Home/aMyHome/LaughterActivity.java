package com.example.bookmyshow.Home.aMyHome;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;

import java.util.ArrayList;

public class LaughterActivity extends AppCompatActivity {

    private ArrayList<StreamingSeeAllItem> seeAllList=new ArrayList<>();
    private RecyclerView recyclerViewLaughter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laughter);
        recyclerViewLaughter=findViewById(R.id.recyclerViewLaughter);
        buildDataForStreaming();
        setDataForStreaming();
    }
    private void setDataForStreaming() {
        StreamingAdapter adapter=new StreamingAdapter(seeAllList);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerViewLaughter.setLayoutManager(gridLayoutManager);
        recyclerViewLaughter.setAdapter(adapter);
    }

    private void buildDataForStreaming() {
        for (int i = 1; i < 5; i++) {
            seeAllList.add(new StreamingSeeAllItem(R.drawable.gauravkapoor, "Gurave Kapoor\nShow", "Bengaluru...", "Comedy Show", "Rs. 599 onwards"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.standupcomedy, "Stand up Comedy \nLive", "Bistro Claytopia", "Stand up comedy", "Rs. 149"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.dongri, "Dongri to\nNowhere", "Good Shepherd", "Comedy Show", "Rs.499 onwards"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.tharlebox, "TharleBox", "Bengaluru", "Comedy Show", "Rs.400"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.introverthell, "Introvert Hell", "Tea Trails", "Stand up Comedy", "Rs.580"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.fantastic, "Fantastic", "Fun Comedy", "Comedy Show", "Free"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.fullenjoy, "Full Enjoy", "Boho Root top", "Stand up Comedy", "Rs.499"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.brunchcomedy, "Brunch Comedy \nShow", "The Grey House...", "Comedy Show", "Rs.100"));
        }
    }
}