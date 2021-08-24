package com.example.bookmyshow.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import com.example.bookmyshow.Home.Buzz.BuzzFragment;
import com.example.bookmyshow.Home.MyHome.HomeFragment;
import com.example.bookmyshow.Home.Profile.ProfileFragment;
import com.example.bookmyshow.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        fragments = new ArrayList<>();

        fragments.add(new HomeFragment());
        fragments.add(new BuzzFragment());
        fragments.add(new ProfileFragment());


        FragmentAdapter pagerAdapter = new FragmentAdapter(getSupportFragmentManager(), getApplicationContext(), fragments);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home_bookmyshow_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.home_buzz_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.home_profile_icon);
        tabLayout.getTabAt(0).setText("Home");
        tabLayout.getTabAt(1).setText("Buzz");
        tabLayout.getTabAt(2).setText("Profile");

        tabLayout.getTabAt(0).getIcon().setColorFilter(getResources().getColor(android.R.color.holo_red_light), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(1).getIcon().setColorFilter(getResources().getColor(android.R.color.darker_gray), PorterDuff.Mode.SRC_IN);
        tabLayout.getTabAt(2).getIcon().setColorFilter(getResources().getColor(android.R.color.darker_gray), PorterDuff.Mode.SRC_IN);
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#808080"));
        tabLayout.setSelectedTabIndicatorHeight((int) (3 * getResources().getDisplayMetrics().density));
        tabLayout.setTabTextColors(Color.parseColor("#808080"), Color.parseColor("#FF0000"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabLayout.getTabAt(tab.getPosition()).getIcon().setColorFilter(getResources().getColor(android.R.color.holo_red_light), PorterDuff.Mode.SRC_IN);
                tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#808080"));
                tabLayout.setSelectedTabIndicatorHeight((int) (3 * getResources().getDisplayMetrics().density));
                tabLayout.setTabTextColors(Color.parseColor("#808080"), Color.parseColor("#FF0000"));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabLayout.getTabAt(tab.getPosition()).getIcon().setColorFilter(getResources().getColor(android.R.color.darker_gray), PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}