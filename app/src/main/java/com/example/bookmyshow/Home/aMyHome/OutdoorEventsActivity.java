package com.example.bookmyshow.Home.aMyHome;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;

import java.util.ArrayList;

public class OutdoorEventsActivity extends AppCompatActivity {
    private ArrayList<StreamingSeeAllItem> seeAllList=new ArrayList<>();
    private RecyclerView recyclerViewOutdoor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outdoor_events);
        recyclerViewOutdoor=findViewById(R.id.recyclerViewOutdoor);
        buildDataForStreaming();
        setDataForStreaming();
    }
    private void setDataForStreaming() {
        StreamingAdapter adapter=new StreamingAdapter(seeAllList);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerViewOutdoor.setLayoutManager(gridLayoutManager);
        recyclerViewOutdoor.setAdapter(adapter);
    }

    private void buildDataForStreaming() {
        for (int i = 1; i < 5; i++) {
            seeAllList.add(new StreamingSeeAllItem(R.drawable.jawaharlal, "Jawaharlal Nehru", "Politics", "Book my show", "Rs. 299"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.clubnight, "That Comedy clud", "Stand up comedy", "Online Streaming", "Free"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.mystory, "Mystery Rooms-\nMumbai", "Escape Games", "Watch on Zoom", "Rs.700 onwards"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.sitdown, "Sit Down", "Restaurant", "Watch on Zoom", "Rs.480"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.wonderala, "Wonderala Event", "Fun Games", "Watch on BookMyShow", "Rs.690"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.fantastic, "Fantastic", "Fun", "Online Streaming", "Free"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.wow, "Wow Wednesday", "Vapour Pub", "NightLife", "Rs. 467"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.skandagiri, "Skandagiri \npoint", "Sunrise meeting point", "Trekking", "Rs.1288"));
        }
    }
}