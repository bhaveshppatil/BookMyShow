package com.example.bookmyshow.Home.aMyHome.MovieRecycler.Fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;

import java.util.List;

interface ClickListener {
    void onItemClick(TheaterLocationModel locationModel);
}

public class TheaterAdapter extends RecyclerView.Adapter<DataViewHolder> {

    private List<TheaterLocationModel> modelList;
    private ClickListener clickListener;

    public TheaterAdapter(List<TheaterLocationModel> modelList, ClickListener clickListener) {
        this.modelList = modelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.select_time_theater, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        TheaterLocationModel timeModel = modelList.get(position);
        holder.setData(timeModel, clickListener);

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

}

class TheaterLocationModel {

    private String tvShowTime1, tvShowTime2, theaterLocation;

    public TheaterLocationModel(String tvShowTime1, String tvShowTime2, String theaterLocation) {
        this.tvShowTime1 = tvShowTime1;
        this.tvShowTime2 = tvShowTime2;
        this.theaterLocation = theaterLocation;
    }

    public String getTvShowTime1() {
        return tvShowTime1;
    }

    public void setTvShowTime1(String tvShowTime1) {
        this.tvShowTime1 = tvShowTime1;
    }

    public String getTvShowTime2() {
        return tvShowTime2;
    }

    public void setTvShowTime2(String tvShowTime2) {
        this.tvShowTime2 = tvShowTime2;
    }

    public String getTheaterLocation() {
        return theaterLocation;
    }

    public void setTheaterLocation(String theaterLocation) {
        this.theaterLocation = theaterLocation;
    }

}

class DataViewHolder extends RecyclerView.ViewHolder {
    private LinearLayout layoutMovieTime;

    private TextView tvShowTime2, tvShowTime1, tvTheaterLocation;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvShowTime2 = itemView.findViewById(R.id.tvShowTime2);
        tvShowTime1 = itemView.findViewById(R.id.tvShowTime1);
        tvTheaterLocation = itemView.findViewById(R.id.tvTheaterName);
        layoutMovieTime = itemView.findViewById(R.id.layoutMovieTime);
    }

    public void setData(TheaterLocationModel locationModel, ClickListener clickListener) {

        tvTheaterLocation.setText(locationModel.getTheaterLocation());
        tvShowTime1.setText(locationModel.getTvShowTime1());
        tvShowTime2.setText(locationModel.getTvShowTime2());

        layoutMovieTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(locationModel);
            }
        });
    }
}