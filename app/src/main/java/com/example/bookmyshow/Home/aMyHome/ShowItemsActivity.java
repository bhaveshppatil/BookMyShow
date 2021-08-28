package com.example.bookmyshow.Home.aMyHome;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.bookmyshow.R;

public class ShowItemsActivity extends AppCompatActivity {
    private ImageView image;
    private TextView eventName;
    private TextView whereToWatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_items);
        image=findViewById(R.id.imageView);
        eventName=findViewById(R.id.txtEventName);
        whereToWatch=findViewById(R.id.txtWhereToWatch);
        Intent intent=getIntent();
        String image1=intent.getStringExtra("Image");
        String name=intent.getStringExtra("EventName");
        String watch=intent.getStringExtra("EventWhereToWatch");
        Glide.with(image).load(image1).into(image);
        eventName.setText(name);
        whereToWatch.setText(watch);
    }
}