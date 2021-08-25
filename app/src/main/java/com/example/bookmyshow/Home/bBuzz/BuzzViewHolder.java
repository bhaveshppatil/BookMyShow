package com.example.bookmyshow.Home.bBuzz;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookmyshow.Home.bBuzz.Network.models.Article;
import com.example.bookmyshow.Home.bBuzz.Network.models.response.ArticleResponse;
import com.example.bookmyshow.R;

import java.util.ArrayList;

public class BuzzViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvBuzzImage;
    private TextView mTvBuzzTitle, mTvBuzzTime;

    public BuzzViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvBuzzImage = itemView.findViewById(R.id.ivBuzzImage);
        mTvBuzzTitle = itemView.findViewById(R.id.tvBuzzTitle);
        mTvBuzzTime = itemView.findViewById(R.id.tvBuzzTime);
    }

    public void setData(Article article) {
        Glide.with(mIvBuzzImage).load(article.getUrlToImage()).into(mIvBuzzImage);
        mTvBuzzTitle.setText(article.getTitle());
        mTvBuzzTime.setText(article.getPublishedAt());
    }
}