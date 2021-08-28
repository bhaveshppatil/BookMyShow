package com.example.bookmyshow.Home.aMyHome.MovieRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
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
