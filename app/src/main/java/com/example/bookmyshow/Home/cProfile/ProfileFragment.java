package com.example.bookmyshow.Home.cProfile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.bookmyshow.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {

    private FirebaseAuth mAuth;
    private View profileViewBar, pPurchaseHistoryBar;
    private ImageView profileTopImage;

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        Glide.with(profileTopImage).load(user.getPhotoUrl()).into(profileTopImage);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mAuth = FirebaseAuth.getInstance();
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    private void initViews(View view) {
        profileViewBar = view.findViewById(R.id.vTopBarProfile);
        pPurchaseHistoryBar = view.findViewById(R.id.purchaseHistoryBar);
        profileTopImage = view.findViewById(R.id.ivProfileTopImage);
        profileViewBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), UserDetailsActivity.class);
                startActivity(intent);
            }
        });
        pPurchaseHistoryBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getContext(), PurchaseHistoryActivity.class);
                startActivity(intent1);
            }
        });
    }

}