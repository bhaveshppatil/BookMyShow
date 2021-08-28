package com.example.bookmyshow.Home.aMyHome.MovieRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<MoviesModel> moviesModelList;
    private ClickListener clickListener;

    public MovieAdapter(List<MoviesModel> moviesModelList, ClickListener clickListener) {
        this.moviesModelList = moviesModelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_layout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        MoviesModel moviesModel = moviesModelList.get(position);
        holder.setData(moviesModel, clickListener);
    }

    @Override
    public int getItemCount() {
        return moviesModelList.size();
    }
}

class MoviesModel {
    private String movieTitle, languages;
    private int thumbID;

    public MoviesModel(String movieTitle, String languages, int thumbID) {
        this.movieTitle = movieTitle;
        this.thumbID = thumbID;
        this.languages = languages;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public int getThumbID() {
        return thumbID;
    }

    public void setThumbID(int thumbID) {
        this.thumbID = thumbID;
    }
}

class MovieViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle, tvLanguages;
    private ImageView ivThumbnail;
    private ClickListener clickListener;
    private CardView cardView;

    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvTitle = itemView.findViewById(R.id.tvMovieTitle);
        ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
        cardView = itemView.findViewById(R.id.movieCard);
        tvLanguages = itemView.findViewById(R.id.tvLanguages);

    }

    public void setData(MoviesModel moviesModel, ClickListener clickListener) {
        tvTitle.setText(moviesModel.getMovieTitle());
        tvLanguages.setText(moviesModel.getLanguages());
        ivThumbnail.setImageResource(moviesModel.getThumbID());
        cardView.setRadius(7.8f);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(moviesModel, getAdapterPosition());
            }
        });
    }
}
