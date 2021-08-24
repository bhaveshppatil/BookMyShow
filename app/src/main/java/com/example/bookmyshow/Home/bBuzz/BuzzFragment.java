package com.example.bookmyshow.Home.bBuzz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookmyshow.R;

import java.util.ArrayList;

public class BuzzFragment extends Fragment {

    private RecyclerView hBuzzRecyclerView;
    private ArrayList<BuzzModel> buzzList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buzz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hBuzzRecyclerView = view.findViewById(R.id.buzzRecyclerView);
        buildList();
        setRecyclerView();
    }

    private void setRecyclerView() {
        BuzzAdapter buzzAdapter = new BuzzAdapter(buzzList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        hBuzzRecyclerView.setLayoutManager(linearLayoutManager);
        hBuzzRecyclerView.setAdapter(buzzAdapter);
    }

    private void buildList() {
        for (int i = 0; i < 25; i++) {
            BuzzModel buzzModel1 = new BuzzModel(R.drawable.kareena, "Kareena Kapoor's son Jeh gets a kiss from cousin Inaaya on his first Raksha Bandhan, see pic", "5 Hours ago");
            buzzList.add(buzzModel1);
            BuzzModel buzzModel2 = new BuzzModel(R.drawable.salman, "Trouble For CISF Officer Who Stopped Salman Khan at Mumbai Airport For Checking", "10 Hours ago");
            buzzList.add(buzzModel2);
        }
    }

}