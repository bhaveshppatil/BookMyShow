package com.example.bookmyshow.Home.bBuzz.News;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.bookmyshow.Home.bBuzz.BuzzAdapter;
import com.example.bookmyshow.Home.bBuzz.Network.NewsApiClient;
import com.example.bookmyshow.Home.bBuzz.Network.models.request.TopHeadlinesRequest;
import com.example.bookmyshow.Home.bBuzz.Network.models.response.ArticleResponse;
import com.example.bookmyshow.Home.bBuzz.OnItemClickListener;
import com.example.bookmyshow.R;

public class EntertainmentFragment extends Fragment implements OnItemClickListener {

    private RecyclerView hBuzzEntertainmentRecyclerView;
    private ArticleResponse hBuzzEntertainmentArticleResponse;
    private WebView hBuzzEntertainmentWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_entertainment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hBuzzEntertainmentRecyclerView = view.findViewById(R.id.buzzEntertainmentRecyclerView);
        hBuzzEntertainmentWebView = view.findViewById(R.id.buzzEntertainmentWebView);
        NewsApiClient newsApiClient = new NewsApiClient("265108157abf4886a7937bcb98778203");
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
                        BuzzAdapter buzzAdapter = new BuzzAdapter(getContext(), response.getArticles(), EntertainmentFragment.this);
                        hBuzzEntertainmentArticleResponse = response;
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        hBuzzEntertainmentRecyclerView.setLayoutManager(linearLayoutManager);
                        hBuzzEntertainmentRecyclerView.setAdapter(buzzAdapter);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
    }

    @Override
    public void onClick(int position) {
        hBuzzEntertainmentWebView.setVisibility(View.VISIBLE);
        hBuzzEntertainmentWebView.loadUrl(hBuzzEntertainmentArticleResponse.getArticles().get(position).getUrl());
    }

}