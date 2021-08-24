package com.example.bookmyshow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SliderView sliderView,sliderView1;
    private ArrayList<Integer> list=new ArrayList<>();
    private ArrayList<imageSliderItem> items=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderView=findViewById(R.id.image_slider);
        sliderView1=findViewById(R.id.image_slider_two);
        list.add(R.drawable.image1);
        list.add(R.drawable.image2);
        list.add(R.drawable.image3);
        setImges();
        setDataForSecondSlider();
        setSliderForSecond();
    }

    private void setSliderForSecond() {
        ImageSliderAdapter sliderAdapter=new ImageSliderAdapter(items);
        sliderView1.setSliderAdapter(sliderAdapter);
        sliderView1.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView1.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView1.startAutoCycle();
    }

    private void setDataForSecondSlider() {
        items.add(new imageSliderItem(R.drawable.magialnight,"On Magical Night","1h 50m, Comedy,18+","English, Hindi, French","this is a greate moive of making"));
        items.add(new imageSliderItem(R.drawable.beckyposter,"On Magical Night","1h 50m, Comedy,18+","English, Hindi, French","this is a greate moive of making"));
    }

    private void setImges() {
        SliderAdapter adapter=new SliderAdapter(list);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }


}