package com.example.my_news_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.my_news_app.Model.NewsApiResponce;
import com.example.my_news_app.Model.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Select_listener, View.OnClickListener {

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

        searchView = findViewById(R.id.search_id);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Loading..." +query);
                progressDialog.show();
                RequestManager manager = new RequestManager(MainActivity.this);
                manager.getNewsHeadlines(listner, "general", query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        btn1= findViewById(R.id.btn_1_id);
        btn1.setOnClickListener(this);
        btn2= findViewById(R.id.btn_2_id);
        btn2.setOnClickListener(this);
        btn3= findViewById(R.id.btn_3_id);
        btn3.setOnClickListener(this);
        btn4= findViewById(R.id.btn_4_id);
        btn4.setOnClickListener(this);
        btn5= findViewById(R.id.btn_5_id);
        btn5.setOnClickListener(this);
        btn6= findViewById(R.id.btn_6_id);
        btn6.setOnClickListener(this);
        btn7= findViewById(R.id.btn_7_id);
        btn7.setOnClickListener(this);


        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getNewsHeadlines(listner, "general", null);

    }

    private final OnFetchDataListner<NewsApiResponce> listner = new OnFetchDataListner<NewsApiResponce>() {

        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {

            if (list.isEmpty()) {
                Toast.makeText(MainActivity.this, "No Data Found!", Toast.LENGTH_LONG).show();
            }else
            {
                showNews(list);
                progressDialog.dismiss();
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
        customAdapter = new CustomAdapter(this, list, this);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void On_newsClicked(NewsHeadlines headlines) {
        startActivity(new Intent(MainActivity.this, Details_Activity.class)
        .putExtra("data", headlines));

    }

    @Override
    public void onClick(View view) {
        Button button = (Button) view;
        String category = button.getText().toString();
        progressDialog.setTitle("Loading...." +category);
        progressDialog.show();

        RequestManager manager = new RequestManager(MainActivity.this);
        manager.getNewsHeadlines(listner, "category", null);
    }
}