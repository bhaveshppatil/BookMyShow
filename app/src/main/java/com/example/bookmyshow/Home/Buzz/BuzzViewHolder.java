package com.example.bookmyshow.Home.Buzz;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;

public class BuzzViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvBuzzImage;
    private TextView mTvName, mTvAge, mTvDob, mTvAddress;

    public BuzzViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mIvBuzzImage = itemView.findViewById(R.id.ivBuzzImage);
        mTvName = itemView.findViewById(R.id.tvBuzzTitle);
    }

    public void setData(BuzzModel buzzModel) {
        mIvBuzzImage.setImageResource(buzzModel.getBuzzImageId());
        mTvName.setText(buzzModel.getBuzzTitle());

    }
}