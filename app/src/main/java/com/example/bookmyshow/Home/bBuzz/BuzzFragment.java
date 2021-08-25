package com.example.bookmyshow.Home.bBuzz;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bookmyshow.Home.bBuzz.Network.NewsApiClient;
import com.example.bookmyshow.Home.bBuzz.Network.models.request.TopHeadlinesRequest;
import com.example.bookmyshow.Home.bBuzz.Network.models.response.ArticleResponse;
import com.example.bookmyshow.R;

public class BuzzFragment extends Fragment {

    private RecyclerView hBuzzRecyclerView;
    private ArticleResponse articleResponse;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buzz, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hBuzzRecyclerView = view.findViewById(R.id.buzzRecyclerView);
        NewsApiClient newsApiClient = new NewsApiClient("8e85a7edf08843158833434a0df50e20");
        // /v2/top-headlines
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .language("en")
                        .country("in")
                        .category("entertainment")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        BuzzAdapter buzzAdapter = new BuzzAdapter(response.getArticles());
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        hBuzzRecyclerView.setLayoutManager(linearLayoutManager);
                        hBuzzRecyclerView.setAdapter(buzzAdapter);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
    }
}