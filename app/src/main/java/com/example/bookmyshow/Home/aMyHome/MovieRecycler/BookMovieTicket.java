package com.example.bookmyshow.Home.aMyHome.MovieRecycler;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookmyshow.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class BookMovieTicket extends AppCompatActivity {

    String api_key = "AIzaSyDEg2fiadvCt-Yq9TlwOPMKFBziRBea1zA";
    private ImageView ivThumbnail;
    private YouTubePlayerView youTubePlayerView;
    private TextView text3, text4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_movie_ticket);

        youTubePlayerView = findViewById(R.id.activity_main_youtubePlayerView);
        getLifecycle().addObserver(youTubePlayerView);

        TextView text2 = findViewById(R.id.text2);
        text2.setText(getString(R.string.lorem_ipsum2));

    }
}