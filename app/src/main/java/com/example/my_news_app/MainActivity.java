package com.example.my_news_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.my_news_app.Model.NewsApiResponce;
import com.example.my_news_app.Model.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    CustomAdapter customAdapter;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7;
    ProgressDialog progressDialog;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Fetching News Articles");
        progressDialog.show();

        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getNewsHeadlines(listner, "general", null);

    }

    private final OnFetchDataListner<NewsApiResponce> listner = new OnFetchDataListner<NewsApiResponce>() {

        @Override
        public void onFetchData(List<NewsHeadlines> data, String message) {
            showNews(data);
            progressDialog.dismiss();
            if (data.isEmpty()) {
                Toast.makeText(MainActivity.this, "No Data Found!", Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView = findViewById(R.id.recycler_main_id);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        customAdapter = new CustomAdapter(this, list);
        recyclerView.setAdapter(customAdapter);
    }

}