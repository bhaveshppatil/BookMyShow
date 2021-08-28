package com.example.bookmyshow.Home.aMyHome.MovieRecycler.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookmyshow.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class LanguageFragment extends BottomSheetDialogFragment {

    private Button btn2D, btn3D;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_language, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn2D = view.findViewById(R.id.btn2D);
        btn3D = view.findViewById(R.id.btn3D);

        btn3D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn3D.setBackgroundColor(Color.parseColor("#C62222"));
                btn3D.setTextColor(Color.parseColor("#FFFFFF"));
                Intent intent = new Intent(getContext(), SelectTimeLocation.class);
                startActivity(intent);

            }
        });

        btn2D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2D.setTextColor(Color.parseColor("#FFFFFF"));
                btn2D.setBackgroundColor(Color.parseColor("#C62222"));
                Intent intent = new Intent(getContext(), SelectTimeLocation.class);
                startActivity(intent);
            }
        });
    }
}