package com.example.bookmyshow.Home.aMyHome.MovieRecycler;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;

import java.util.ArrayList;
import java.util.List;

public class Movies extends AppCompatActivity implements View.OnClickListener {

    private Button btnEnglish, btnHindi, btnTelugu, btnJapanese, btnPunjabi;

    private RecyclerView recyclerView;
    private List<MoviesModel> moviesModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        initViews();
        buildMoviesData();
        setRecyclerView();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        btnEnglish = findViewById(R.id.btnEnglish);
        btnHindi = findViewById(R.id.btnHindi);
        btnPunjabi = findViewById(R.id.btnPunjabi);
        btnJapanese = findViewById(R.id.btnJapanese);
        btnTelugu = findViewById(R.id.btnTelugu);

        btnTelugu.setOnClickListener(this);
        btnEnglish.setOnClickListener(this);
        btnHindi.setOnClickListener(this);
        btnJapanese.setOnClickListener(this);
        btnPunjabi.setOnClickListener(this);

    }

    private void buildMoviesData() {
        moviesModelList.add(new MoviesModel("Bell Bottom", "Hindi", R.drawable.bottom));
        moviesModelList.add(new MoviesModel("Chehre", "Hindi", R.drawable.chehre));
        moviesModelList.add(new MoviesModel("The Conjuring: The Devil Made Me Do It", "English, Hindi,Telugu, Tamil", R.drawable.conjuring));
        moviesModelList.add(new MoviesModel("Sridevi Soda Center", "English, Telugu,", R.drawable.sridevi_soda));
        moviesModelList.add(new MoviesModel("Ichata Vahanamulu Nilupa Radu", "Telugu", R.drawable.nupa_radui));
        moviesModelList.add(new MoviesModel("Raja Raja Chora", "Telugu", R.drawable.raja_raja_chora));
        moviesModelList.add(new MoviesModel("House Arrest", "Telugu", R.drawable.arrest));
        moviesModelList.add(new MoviesModel("Paagal", "Telugu", R.drawable.house));
        moviesModelList.add(new MoviesModel("KGF", "Telugu, Hindi", R.drawable.kgf));
        moviesModelList.add(new MoviesModel("Reminiscence", "Telugu, Hindi, English", R.drawable.reminiscence));
        moviesModelList.add(new MoviesModel("The Suicide Squad", "Hindi, English", R.drawable.the_suicide));
        moviesModelList.add(new MoviesModel("Cheruvaina Dooramaina", "Telugu", R.drawable.cheruvaina_dooramaina));
        moviesModelList.add(new MoviesModel("The Green Knight", "English", R.drawable.green));
        moviesModelList.add(new MoviesModel("Sridevi Soda Center", "English, Telugu,", R.drawable.sridevi_soda));
        moviesModelList.add(new MoviesModel("Ichata Vahanamulu Nilupa Radu", "Telugu", R.drawable.nupa_radui));
        moviesModelList.add(new MoviesModel("Raja Raja Chora", "Telugu", R.drawable.raja_raja_chora));
        moviesModelList.add(new MoviesModel("House Arrest", "Telugu", R.drawable.arrest));
        moviesModelList.add(new MoviesModel("Paagal", "Telugu", R.drawable.house));
        moviesModelList.add(new MoviesModel("KGF", "Telugu, Hindi", R.drawable.kgf));
        moviesModelList.add(new MoviesModel("Reminiscence", "Telugu, Hindi, English", R.drawable.reminiscence));
    }

    private void setRecyclerView() {
        MovieAdapter movieAdapter = new MovieAdapter(moviesModelList);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setAdapter(movieAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnEnglish:
                btnEnglish.setBackgroundColor(ContextCompat.getColor(btnEnglish.getContext(), R.color.light_red));
                btnEnglish.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case R.id.btnHindi:
                btnHindi.setBackgroundColor(ContextCompat.getColor(btnHindi.getContext(), R.color.light_red));
                btnHindi.setTextColor(Color.parseColor("#FFFFFF"));

                break;
            case R.id.btnPunjabi:
                btnPunjabi.setBackgroundColor(ContextCompat.getColor(btnPunjabi.getContext(), R.color.light_red));
                btnPunjabi.setTextColor(Color.parseColor("#FFFFFF"));

                break;
            case R.id.btnJapanese:
                btnJapanese.setBackgroundColor(ContextCompat.getColor(btnJapanese.getContext(), R.color.light_red));
                btnJapanese.setTextColor(Color.parseColor("#FFFFFF"));

                break;
            case R.id.btnTelugu:
                btnTelugu.setBackgroundColor(ContextCompat.getColor(btnTelugu.getContext(), R.color.light_red));
                btnTelugu.setTextColor(Color.parseColor("#FFFFFF"));
                break;
        }
    }
}