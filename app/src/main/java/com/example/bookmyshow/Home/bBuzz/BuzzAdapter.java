package com.example.bookmyshow.Home.bBuzz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.Home.bBuzz.Network.models.Article;
import com.example.bookmyshow.R;

import java.util.List;

public class BuzzAdapter extends RecyclerView.Adapter<BuzzViewHolder> {

    private List<Article> buzzList;

    public BuzzAdapter(List<Article> bList) {
        this.buzzList = bList;
    }

    @NonNull
    @Override
    public BuzzViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buzz_item_layout, parent, false);
        return new BuzzViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BuzzViewHolder holder, int position) {
        holder.setData(buzzList.get(position));
    }

    @Override
    public int getItemCount() {
        return buzzList.size();
    }
}