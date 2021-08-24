package com.example.bookmyshow.Home.Buzz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;

import java.util.ArrayList;

public class BuzzAdapter extends RecyclerView.Adapter<BuzzViewHolder> {

    private ArrayList<BuzzModel> buzzList;

    public BuzzAdapter(ArrayList<BuzzModel> bList) {
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
        BuzzModel buzzModel = buzzList.get(position);
        holder.setData(buzzModel);
    }

    @Override
    public int getItemCount() {
        return buzzList.size();
    }
}