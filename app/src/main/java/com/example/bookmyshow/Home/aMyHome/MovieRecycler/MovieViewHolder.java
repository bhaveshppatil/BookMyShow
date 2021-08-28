package com.example.bookmyshow.Home.aMyHome.MovieRecycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {

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