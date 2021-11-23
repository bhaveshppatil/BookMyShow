package com.teamBookMyShow.bookmyshow.Home.bBuzz.News;

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

import com.teamBookMyShow.bookmyshow.Home.bBuzz.BuzzAdapter;
import com.teamBookMyShow.bookmyshow.Home.bBuzz.Network.NewsApiClient;
import com.teamBookMyShow.bookmyshow.Home.bBuzz.Network.models.request.TopHeadlinesRequest;
import com.teamBookMyShow.bookmyshow.Home.bBuzz.Network.models.response.ArticleResponse;
import com.teamBookMyShow.bookmyshow.Home.bBuzz.OnItemClickListener;
import com.teamBookMyShow.bookmyshow.R;

public class SportsFragment extends Fragment implements OnItemClickListener {

    private RecyclerView hBuzzSportsRecyclerView;
    private ArticleResponse hBuzzSportsArticleResponse;
    private WebView hBuzzSportsWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sports, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hBuzzSportsRecyclerView = view.findViewById(R.id.buzzSportsRecyclerView);
        hBuzzSportsWebView = view.findViewById(R.id.buzzSportsWebView);
        NewsApiClient newsApiClient = new NewsApiClient("187bbe8bdd6a41ca92244c9b0042425d");
        // /v2/top-headlines
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .language("en")
                        .country("in")
                        .category("sports")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        BuzzAdapter buzzAdapter = new BuzzAdapter(getContext(), response.getArticles(), SportsFragment.this);
                        hBuzzSportsArticleResponse = response;
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                        hBuzzSportsRecyclerView.setLayoutManager(linearLayoutManager);
                        hBuzzSportsRecyclerView.setAdapter(buzzAdapter);
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
        hBuzzSportsWebView.setVisibility(View.VISIBLE);
        hBuzzSportsWebView.loadUrl(hBuzzSportsArticleResponse.getArticles().get(position).getUrl());
    }

}