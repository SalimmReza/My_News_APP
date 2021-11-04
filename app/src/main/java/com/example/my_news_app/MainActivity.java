package com.example.my_news_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
//https://newsapi.org/v2/top-headlines?country=us&apiKey=b89cae9e325d447bad455e15420f1630
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}