package com.example.bookmyshow.Home.aMyHome;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;

import java.util.ArrayList;

public class StreamingSeeAllActivity extends AppCompatActivity {
    private ArrayList<StreamingSeeAllItem> seeAllList=new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streaming_see_all);
        recyclerView=findViewById(R.id.recyclerView);
        buildDataForStreaming();
        setDataForStreaming();
    }
    private void setDataForStreaming() {
        StreamingAdapter adapter=new StreamingAdapter(seeAllList);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void buildDataForStreaming() {
        for (int i = 1; i < 5; i++) {
            seeAllList.add(new StreamingSeeAllItem(R.drawable.mic, "FrontRow Open Mics", "Comedy Shows", "Watch on Zoom", "Free"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.digitalmarketing, "Digital Marketing & Communication", "Education", "Online Streaming", "Free"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.vipulgoyal, "Vipul Goyal Live", "Stand up Comedy", "Watch on Zoom", "Rs.599 onwards"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.datascience, "Data Science", "Education", "Online Streaming", "Free"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.barkharitu, "Barkha Ritu", "Music", "Watch on BookMyShow", "Rs. 236"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.algebra, "Algebra", "Education", "Online Streaming", "Rs. 400"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.mic, "FrontRow Open Mics", "Comedy Shows", "Watch on Zoom", "Free"));
            seeAllList.add(new StreamingSeeAllItem(R.drawable.vipulgoyal, "Vipul Goyal Live", "Stand up Comedy", "Watch on Zoom", "Free"));
        }
    }
}