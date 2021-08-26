package com.example.bookmyshow.Home.bBuzz.aMyHome;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;

import java.util.ArrayList;

public class StreamingAdapter extends RecyclerView.Adapter<StreamingAdapter.StramingViewHolder> {
     private ArrayList<StreamingSeeAllItem> itemList;
     public StreamingAdapter(ArrayList<StreamingSeeAllItem> itemList){
         this.itemList=itemList;
     }

    @NonNull
    @Override
    public StramingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.streaming_seeall_item_layout,parent,false);
         return new StramingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StramingViewHolder holder, int position) {
        StreamingSeeAllItem item=itemList.get(position);
        holder.setData(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class StramingViewHolder extends RecyclerView.ViewHolder{
         ImageView eventImage;
         TextView eventName;
         TextView eventType;
         TextView eventWatch;
         TextView eventPrice;

        public StramingViewHolder(@NonNull View itemView) {
            super(itemView);
            eventImage=itemView.findViewById(R.id.streamingImage);
            eventName=itemView.findViewById(R.id.txtEventName);
            eventType=itemView.findViewById(R.id.txtEventType);
            eventWatch=itemView.findViewById(R.id.txtWhereToWatch);
            eventPrice=itemView.findViewById(R.id.txtPrice);
        }
        public void setData(StreamingSeeAllItem item){
            eventImage.setImageResource(item.getEventImage());
            eventName.setText(item.getEventName());
            eventType.setText(item.getEventType());
            eventWatch.setText(item.getEventWhereToWatch());
            eventPrice.setText(item.getEventPrice());
        }
    }
}
