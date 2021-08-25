package com.example.bookmyshow.Home.aMyHome;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;

import java.util.ArrayList;

public class SportActivity extends AppCompatActivity {

    private ArrayList<StreamingSeeAllItem> seeAllList=new ArrayList<>();
    private RecyclerView recyclerViewSport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
        recyclerViewSport=findViewById(R.id.recyclerViewSport);
        buildDataForStreaming();
        setDataForStreaming();
    }
    private void setDataForStreaming() {
        StreamingAdapter adapter=new StreamingAdapter(seeAllList);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerViewSport.setLayoutManager(gridLayoutManager);
        recyclerViewSport.setAdapter(adapter);
    }

    private void buildDataForStreaming() {
        for (int i = 1; i < 5; i++) {
            seeAllList.add(new StreamingSeeAllItem(R.drawable.losttreasur, "Lost Treasur\nGames", "Online(Play From..", "E Sports", "Rs.400 onwards"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.pool, "Pool A New \nZealand", "Online(Play From..", "E Sports", "Rs. 499"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.clues, "Give Clues", "Online(Play From..", "E Sports", "Rs.598"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.bgmi, "BGMI-\nTournament", "Online(Play From..", "E Sports", "Rs.400"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.indianchess, "Indian Chess\n2021", "Online(Play From..", "E Sports", "Rs.580"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.knight, "Knight Chess", "Online(Play From..", "E Sports", "Free"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.flight, "Flight Games", "Online(Play From..", "E Sports", "Rs.499"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.haunted, "Haunted House", "Online(Play From..", "E Sports", "Rs.100"));
        }
    }
}