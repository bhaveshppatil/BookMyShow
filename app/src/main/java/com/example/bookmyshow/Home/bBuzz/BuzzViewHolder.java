package com.example.bookmyshow.Home.bBuzz;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bookmyshow.Home.bBuzz.Network.models.Article;
import com.example.bookmyshow.R;

public class BuzzViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvBuzzImage;
    private TextView mTvBuzzTitle, mTvBuzzTime;
    private RelativeLayout rl;
    private OnItemClickListener onItemClickListener;

    public BuzzViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
        super(itemView);
        this.onItemClickListener = onItemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvBuzzImage = itemView.findViewById(R.id.ivBuzzImage);
        mTvBuzzTitle = itemView.findViewById(R.id.tvBuzzTitle);
        mTvBuzzTime = itemView.findViewById(R.id.tvBuzzTime);
        rl = itemView.findViewById(R.id.buzzItemLayoutRelativeLayout);
        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(getAdapterPosition());
            }
        });
    }

    public void setData(Article article) {
        Glide.with(mIvBuzzImage).load(article.getUrlToImage()).into(mIvBuzzImage);
        mTvBuzzTitle.setText(article.getTitle());
        mTvBuzzTime.setText(article.getPublishedAt());
    }

}