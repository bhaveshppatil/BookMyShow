package com.teamBookMyShow.bookmyshow.RegisterEvent;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPageAdapter extends FragmentStateAdapter {

    public ViewPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new SelectDateTime();
            case 1:
                return new SelectTicketQuantity();
            case 2:
                return new RegistrationFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}