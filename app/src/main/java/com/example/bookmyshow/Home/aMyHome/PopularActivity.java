package com.example.bookmyshow.Home.aMyHome;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;

import java.util.ArrayList;

public class PopularActivity extends AppCompatActivity {

    private ArrayList<StreamingSeeAllItem> seeAllList=new ArrayList<>();
    private RecyclerView recyclerViewPopular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular);
        recyclerViewPopular=findViewById(R.id.recyclerViewPopular);
        buildDataForStreaming();
        setDataForStreaming();
    }
    private void setDataForStreaming() {
        StreamingAdapter adapter=new StreamingAdapter(seeAllList);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerViewPopular.setLayoutManager(gridLayoutManager);
        recyclerViewPopular.setAdapter(adapter);
    }

    private void buildDataForStreaming() {
        for (int i = 1; i < 5; i++) {
            seeAllList.add(new StreamingSeeAllItem(R.drawable.celebfie, "Celebfie-Cruise", "Ballard Estate...", "Music", "Rs.10400 onwards"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.kaadiwild, "Kaafi Wild Hai", "Vapour Pub And..", "Stand up comedy", "Rs. 499"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.firstlanguage, "First Language", "Learning", "Education", "Rs.598"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.saaz, "Saaz", "Bengaluru", "Music", "Rs.400"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.introverthell, "Introvert Hell", "Tea Trails", "Stand up Comedy", "Rs.580"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.fantastic, "Fantastic", "Fun Comedy", "Comedy Show", "Free"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.fullenjoy, "Full Enjoy", "Boho Root top", "Stand up Comedy", "Rs.499"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.brunchcomedy, "Brunch Comedy \nShow", "The Grey House...", "Comedy Show", "Rs.100"));
        }
    }
}