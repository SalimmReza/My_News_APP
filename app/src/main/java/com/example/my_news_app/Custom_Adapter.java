package com.example.my_news_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_news_app.Model.News_Headlines;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Custom_Adapter extends RecyclerView.Adapter<Custon_view_holder> {

    private Context context;
    private List<News_Headlines> headlines;

    public Custom_Adapter(Context context, List<News_Headlines> headlines) {
        this.context = context;
        this.headlines = headlines;
    }

    @NonNull
    @Override
    public Custon_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new Custon_view_holder(LayoutInflater.from(context).inflate(R.layout.headline_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull Custon_view_holder holder, int position) {

        holder.title.setText(headlines.get(position).getTitle());
        holder.source.setText(headlines.get(position).getSource().getName());

        if (headlines.get(position).getUrlToImage()!= null)
        {
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.headline);
        }

    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
