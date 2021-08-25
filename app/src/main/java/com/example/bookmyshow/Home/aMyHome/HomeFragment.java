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
    private TextView seeAllStreaming;
    private TextView seeAllOutdoorEvent;
    private TextView seeAllPopular;
    private TextView seeAllLaughter;
    private TextView seeAllSport;
    private ArrayList<Integer> list = new ArrayList<>();
    private ArrayList<imageSliderItem> items = new ArrayList<>();


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //setContentView(R.layout.activity_main);
        sliderView = view.findViewById(R.id.image_slider);
        sliderView1 = view.findViewById(R.id.image_slider_two);
        seeAllSport=view.findViewById(R.id.txtSeeAllSport);
        seeAllStreaming=view.findViewById(R.id.txtSeeAllStreaming);
        seeAllOutdoorEvent=view.findViewById(R.id.txtSeeAllOutdoor);
        seeAllPopular=view.findViewById(R.id.txtSeeAllPopular);
        seeAllLaughter=view.findViewById(R.id.txtSeeAllLaughter);
        seeAllSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),SportActivity.class);
                startActivity(intent);
            }
        });
        seeAllLaughter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),LaughterActivity.class);
                startActivity(intent);
            }
        });
        seeAllPopular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),PopularActivity.class);
                startActivity(intent);
            }
        });
        seeAllStreaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),StreamingSeeAllActivity.class);
                startActivity(intent);
            }
        });
        seeAllOutdoorEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),OutdoorEventsActivity.class);
                startActivity(intent);
            }
        });
        list.add(R.drawable.image1);
        list.add(R.drawable.image2);
        list.add(R.drawable.image3);
        list.add(R.drawable.kid);
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
        items.add(new imageSliderItem(R.drawable.theassistant, "The Assistant", "1h 27m,Drama Thriller, 16+", "English", "Jane, a recent college graduate \nand aspiring film producer,...."));
        items.add(new imageSliderItem(R.drawable.thebalkan, "The Balkan Line", "2h 10m, Action ,16+", "English, Hindi", "After the NATO bombing of\nYugoslavia in 1999 the \nYugoslav army..."));
        items.add(new imageSliderItem(R.drawable.spacejam, "Space Jam:A New\nLegacy", "1h 55m, Animation", "English, Hindi, French", "Basketball superstar LeBron James teams\n up with the Looney Tunes "));
        items.add(new imageSliderItem(R.drawable.oyemamu, "Oye Mamu!", "2h 5m, Comedy,18+", "Hindi", "Dream to become a VJ collide with\na museum trip a diamond..."));
        items.add(new imageSliderItem(R.drawable.heistofcentury, "The Heist Of The\nCentury", "1h 54m, Crime,13+", "English, Spanish", "Inspired by a true story,a group\nof thieves join hands to..."));
        items.add(new imageSliderItem(R.drawable.magialnight, "On Magical Night", "1h 26m, Comedy,18+", " French", "After 20 years of marriage,\nMaria decides to leave..."));
        items.add(new imageSliderItem(R.drawable.beckyposter, "Becky", "1h 33m, Action,18+", "English", "A teenager weekend at a lake \nhouse with her father takes..."));
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