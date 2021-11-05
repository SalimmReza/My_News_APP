package com.example.my_news_app;

import android.content.Context;
import android.widget.Toast;

import com.example.my_news_app.Model.News_api_response;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class Request_manager {
    Context context;

    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create()).build();

            public void getNewsHeadlines(On_fetch_data_listener listener , String category, String query)
            {
                call_news_api call_news_api = retrofit.create(call_news_api.class);
                Call<News_api_response> call = call_news_api.call_headline("bg" , category, query, context.getString(R.string.api_key));

                try {
                    call.enqueue(new Callback<News_api_response>() {
                        @Override
                        public void onResponse(Call<News_api_response> call, Response<News_api_response> response) {

                            if (!response.isSuccessful())
                            {
                                Toast.makeText(context, "Error..", Toast.LENGTH_SHORT).show();
                            }


                            listener.on_fetch_data(response.body().getArticles(), response.message());

                        }

                        @Override
                        public void onFailure(Call<News_api_response> call, Throwable t) {

                            listener.on_error("Failed try again!");
                        }
                    });
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }


    public Request_manager(Context context) {
        this.context = context;

    }
         public  interface call_news_api{
             @GET("top-headlines")
             Call<News_api_response> call_headline(
                     @Query("country") String country,
                     @Query("category") String category,
                     @Query("q") String query,
                     @Query("apiKey") String apiKey

             );
         }

}
