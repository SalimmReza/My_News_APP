package com.example.my_news_app;

import android.content.Context;

import com.example.my_news_app.Model.News_api_response;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Request_manager {
    Context context;

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build();


    public Request_manager(Context context) {
        this.context = context;
         public interface call_news_api{
             Call<News_api_response> call_headline(



             )
         }
    }
}
