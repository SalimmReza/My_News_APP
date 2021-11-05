package com.example.my_news_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.my_news_app.Model.News_Headlines;
import com.example.my_news_app.Model.News_api_response;

import java.util.List;

//https://newsapi.org/v2/top-headlines?country=us&apiKey=b89cae9e325d447bad455e15420f1630
public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Custom_Adapter custom_adapter;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pd = new ProgressDialog(this);
        pd.setTitle("Loading...");
        pd.show();

        Request_manager request_manager = new Request_manager(this);
        request_manager.getNewsHeadlines(listener, "general" , null);
    }

    private final On_fetch_data_listener<News_api_response> listener = new On_fetch_data_listener<News_api_response>() {
        @Override
        public void on_fetch_data(List<News_Headlines> list, String messages) {
            show_news(list);
            pd.dismiss();
        }

        @Override
        public void on_error(String messages) {

        }
    };

    private void show_news(List<News_Headlines> list) {
        recyclerView = findViewById(R.id.recycler_main_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));

        custom_adapter=  new Custom_Adapter(this, list);
        recyclerView.setAdapter(custom_adapter);
    }
}