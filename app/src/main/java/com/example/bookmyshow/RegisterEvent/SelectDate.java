package com.example.bookmyshow.RegisterEvent;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.example.bookmyshow.R;
import com.google.android.material.tabs.TabLayout;


public class SelectDate extends AppCompatActivity implements FragmentCommunication {

    FragmentManager fragmentManager;
    private TabLayout tabLayout;
    private FrameLayout frameLayout;
    private ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);
        frameLayout = findViewById(R.id.fragment_container_view_tag);
        launchDateTimeFrag();
    }

    private void launchDateTimeFrag() {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SelectDateTime selectDateTime = new SelectDateTime();
        fragmentTransaction.add(R.id.fragment_container_view_tag, selectDateTime, "selectDateTime").addToBackStack("addDate").commit();
    }

    @Override
    public void launchSelectTicketFrag(Bundle bundle) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SelectTicketQuantity ticketQuantity = new SelectTicketQuantity();
        ticketQuantity.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_container_view_tag, ticketQuantity, "ticketQuantity").addToBackStack("Quantity").commit();
    }

    @Override
    public void launchContactDetails(Bundle bundle) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        RegistrationFragment registrationFragment = new RegistrationFragment();
        registrationFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fragment_container_view_tag, registrationFragment, "registrationFragment").addToBackStack("registration").commit();

    }
}