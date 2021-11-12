package com.example.my_news_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.my_news_app.Model.NewsHeadlines;
import com.squareup.picasso.Picasso;

public class Details_Activity extends AppCompatActivity {

    NewsHeadlines headlines;
    TextView title, author, time, detail, content;
    ImageView img_news;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        title= findViewById(R.id.text_details_title_id);
        author= findViewById(R.id.text_details_author_id);
        time= findViewById(R.id.text_details_time_id);
        detail= findViewById(R.id.text_detail_detail_id);
        content= findViewById(R.id.text_detail_content_id);
        img_news= findViewById(R.id.img_details_news_id);

        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        title.setText(headlines.getTitle());
        author.setText(headlines.getAuthor());
        time.setText(headlines.getPublishedAt());
        detail.setText(headlines.getDescription());
        content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(img_news);

    }
}