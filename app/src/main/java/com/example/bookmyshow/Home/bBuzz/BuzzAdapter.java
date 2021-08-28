package com.example.bookmyshow.Home.bBuzz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookmyshow.Home.bBuzz.Network.models.Article;
import com.example.bookmyshow.R;

import java.util.List;

public class BuzzAdapter extends RecyclerView.Adapter<BuzzViewHolder> {

    private Context context;
    private List<Article> buzzList;
    private ImageView buzzShare;
    private RelativeLayout hBuzzItemLayoutRelativeLayout;
    private OnItemClickListener onItemClickListener;

    public BuzzAdapter(Context context, List<Article> bList, OnItemClickListener onItemClickListener) {
        this.buzzList = bList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public BuzzViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.buzz_item_layout, parent, false);
        buzzShare = view.findViewById(R.id.ivBuzzShareIcon);
        hBuzzItemLayoutRelativeLayout = view.findViewById(R.id.buzzItemLayoutRelativeLayout);
        return new BuzzViewHolder(view, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BuzzViewHolder holder, int position) {
        holder.setData(buzzList.get(position));
        String tittle = buzzList.get(position).getTitle();
        String url = buzzList.get(position).getUrl();
        buzzShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,
                        tittle +
                                " -\n\n" + url + "\n\n" + "~ via BookMyShow Buzz \uD83D\uDCE3");
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, "Send To"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return buzzList.size();
    }

}