package com.example.my_news_app;

import com.example.my_news_app.Model.News_Headlines;

import java.util.List;

public interface On_fetch_data_listener <News_api_response>{
    void on_fetch_data(List<News_Headlines> list, String message);
    void on_error(String message);
}
