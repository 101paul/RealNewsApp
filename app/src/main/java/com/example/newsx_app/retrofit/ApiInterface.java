package com.example.newsx_app.retrofit;

import com.example.newsx_app.model.mainNews;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("top-headlines")
    Call<mainNews> getNews(
            @Query("country") String country ,
            @Query("category") String category,
            @Query("apiKey") String apiKey
    );
    @GET("everything")
    Call<mainNews> searchForNews(
            @Query("q") String query ,
            @Query("apiKey") String apiKey
    ) ;
}
