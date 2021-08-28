package com.example.bookmyshow.Home.bBuzz;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookmyshow.Home.bBuzz.News.EntertainmentFragment;
import com.example.bookmyshow.Home.bBuzz.News.SportsFragment;
import com.example.bookmyshow.Home.bBuzz.News.TechnologyFragment;
import com.example.bookmyshow.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class BuzzFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_buzz, container, false);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.buzzViewpager);
        setupViewPager(viewPager);
        TabLayout tabs = (TabLayout) view.findViewById(R.id.buzzTabs);
        tabs.setupWithViewPager(viewPager);

        //colour change
        tabs.setSelectedTabIndicatorColor(Color.parseColor("#808080"));
        tabs.setSelectedTabIndicatorHeight((int) (3 * getResources().getDisplayMetrics().density));
        tabs.setTabTextColors(Color.parseColor("#808080"), Color.parseColor("#FF0000"));


        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getChildFragmentManager());
        adapter.addFragment(new EntertainmentFragment(), "Entertainment");
        adapter.addFragment(new SportsFragment(), "Sports");
        adapter.addFragment(new TechnologyFragment(), "Technology");
        viewPager.setAdapter(adapter);
    }

    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }

}