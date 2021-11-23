package com.teamBookMyShow.bookmyshow.Home.bBuzz.Network;

import com.teamBookMyShow.bookmyshow.Home.bBuzz.Network.models.response.ArticleResponse;
import com.teamBookMyShow.bookmyshow.Home.bBuzz.Network.models.response.SourcesResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;


public interface APIService {
    @GET("/v2/sources")
    Call<SourcesResponse> getSources(@QueryMap Map<String, String> query);

    @GET("/v2/top-headlines")
    Call<ArticleResponse> getTopHeadlines(@QueryMap Map<String, String> query);

    @GET("/v2/everything")
    Call<ArticleResponse> getEverything(@QueryMap Map<String, String> query);

}