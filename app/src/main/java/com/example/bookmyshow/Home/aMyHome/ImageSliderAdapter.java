package com.example.bookmyshow.Home.aMyHome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookmyshow.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class ImageSliderAdapter extends SliderViewAdapter<ImageSliderAdapter.ImagerSliderViewHolder>{
    private ArrayList<imageSliderItem> itemList;
    public ImageSliderAdapter(ArrayList<imageSliderItem> itemList){
        this.itemList=itemList;
    }
    @Override
    public ImagerSliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.imageslider_second_layout,parent,false);
        return new ImagerSliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImagerSliderViewHolder viewHolder, int position) {
        imageSliderItem item=itemList.get(position);
        viewHolder.setData(item);

    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    public class ImagerSliderViewHolder extends SliderViewAdapter.ViewHolder{
        ImageView image;
        TextView movieName;
        TextView movieLanguage;
        TextView movieDuration;
        TextView movieDescription;

        public ImagerSliderViewHolder(View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.moiveImage);
            movieName=itemView.findViewById(R.id.txtMovieName);
            movieLanguage=itemView.findViewById(R.id.txtmovieLanguage);
            movieDescription=itemView.findViewById(R.id.txtmovieDescription);
            movieDuration=itemView.findViewById(R.id.txtmovieDuration);
        }
        public void setData(imageSliderItem item){
            image.setImageResource(item.getImages());
            movieName.setText(item.getMovieName());
            movieLanguage.setText(item.getMovieLanguage());
            movieDuration.setText(item.getMovieDuration());
            movieDescription.setText(item.getMovieDescription());
        }
    }
}