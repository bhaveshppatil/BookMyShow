package com.example.bookmyshow.Home.aMyHome.MovieRecycler;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.bookmyshow.Home.aMyHome.MovieRecycler.Fragments.LanguageFragment;
import com.example.bookmyshow.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class BookMovieTicket extends AppCompatActivity {

    private ImageView ivThumbnail;
    private YouTubePlayerView youTubePlayerView;
    private Button btnBookMovieTicket;
    private TextView text3, text4;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_movie_ticket);

        youTubePlayerView = findViewById(R.id.activity_main_youtubePlayerView);
        getLifecycle().addObserver(youTubePlayerView);

        TextView text2 = findViewById(R.id.text2);
        text2.setText(getString(R.string.lorem_ipsum2));
        btnBookMovieTicket = findViewById(R.id.btnBookTicket);

        btnBookMovieTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LanguageFragment languageFragment = new LanguageFragment();
                languageFragment.show(getSupportFragmentManager(), "BottomSheet");

            }
        });
    }
}