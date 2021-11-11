package com.example.my_news_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_news_app.Model.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<NewsHeadlines> headlineList;


    public CustomAdapter(Context context, List<NewsHeadlines> headlineList) {
        this.context = context;
        this.headlineList = headlineList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.text_title.setText(headlineList.get(position).getTitle());
        if (headlineList.get(position).getUrlToImage()!=null){
            Picasso.get().load(headlineList.get(position).getUrlToImage()).into(holder.img_headline);
        }
        holder.text_source.setText(headlineList.get(position).getSource().getName());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return headlineList.size();
    }
}