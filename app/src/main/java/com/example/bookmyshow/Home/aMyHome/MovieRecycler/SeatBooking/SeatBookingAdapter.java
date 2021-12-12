package com.example.bookmyshow.Home.aMyHome.MovieRecycler.SeatBooking;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.R;

import java.util.List;

public class SeatBookingAdapter extends RecyclerView.Adapter<seatViewHolder> {

    private List<SeatBookingModel> seatBookingModelList;
    private SeatClickListener clickListener;

    public SeatBookingAdapter(List<SeatBookingModel> seatBookingModelList, SeatClickListener clickListener) {
        this.seatBookingModelList = seatBookingModelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public seatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.availble_seat_layout, parent, false);
        return new seatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull seatViewHolder holder, int position) {
        SeatBookingModel seatBookingModel = seatBookingModelList.get(position);
        holder.setSeatNumber(seatBookingModel, clickListener);
    }

    @Override
    public int getItemCount() {
        return seatBookingModelList.size();
    }
}

class seatViewHolder extends RecyclerView.ViewHolder {

    private SeatClickListener clickListener;
    private int countSeat = 1;
    private FragmentManager fragmentManager;
    private TextView tvSeatNumber;
    private Button btnPaymentMovie;

    public seatViewHolder(@NonNull View itemView) {
        super(itemView);
        tvSeatNumber = itemView.findViewById(R.id.tvSeatNumber);
    }

    public void setSeatNumber(SeatBookingModel seatNumber, SeatClickListener clickListener) {
        tvSeatNumber.setText(seatNumber.getSeatNumber() + "");

        tvSeatNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvSeatNumber.setBackgroundColor(Color.parseColor("#EC5E71"));
                tvSeatNumber.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });
    }
}

