package com.example.bookmyshow.Home.aMyHome;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bookmyshow.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    SliderView sliderView, sliderView1;
    private TextView seeAll;
    private ArrayList<Integer> list = new ArrayList<>();
    private ArrayList<imageSliderItem> items = new ArrayList<>();


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setContentView(R.layout.activity_main);
        sliderView = view.findViewById(R.id.image_slider);
        sliderView1 = view.findViewById(R.id.image_slider_two);
        seeAll=view.findViewById(R.id.txtSeeAll);
        seeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),StreamingSeeAllActivity.class);
                startActivity(intent);
            }
        });
        list.add(R.drawable.image1);
        list.add(R.drawable.image2);
        list.add(R.drawable.image3);
        setImges();
        setDataForSecondSlider();
        setSliderForSecond();
    }



    private void setSliderForSecond() {
        ImageSliderAdapter sliderAdapter = new ImageSliderAdapter(items);
        sliderView1.setSliderAdapter(sliderAdapter);
        sliderView1.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView1.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView1.startAutoCycle();
    }

    private void setDataForSecondSlider() {
        items.add(new imageSliderItem(R.drawable.magialnight, "On Magical Night", "1h 50m, Comedy,18+", "English, Hindi, French", "this is a greate moive of making"));
        items.add(new imageSliderItem(R.drawable.beckyposter, "On Magical Night", "1h 50m, Comedy,18+", "English, Hindi, French", "this is a greate moive of making"));
    }

    private void setImges() {
        SliderAdapter adapter = new SliderAdapter(list);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }
}