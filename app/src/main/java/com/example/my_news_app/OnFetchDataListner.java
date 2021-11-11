package com.example.my_news_app;

import com.example.my_news_app.Model.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListner<NewsApiResponce> {
    void onFetchData(List<NewsHeadlines> data, String message);

    void onError(String message);
}
