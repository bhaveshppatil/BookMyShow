package com.example.bookmyshow.Home.aMyHome.MovieRecycler.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bookmyshow.Home.aMyHome.MovieRecycler.SelectSeat;
import com.example.bookmyshow.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class TermsAndConditionFragment extends BottomSheetDialogFragment {

    private Button btnAcceptTerms;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_terms_and_condition, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.bottomSheetCorner);

        btnAcceptTerms = view.findViewById(R.id.btnAcceptTerms);

        btnAcceptTerms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), SelectSeat.class);
                startActivity(intent);

            }
        });
    }
}