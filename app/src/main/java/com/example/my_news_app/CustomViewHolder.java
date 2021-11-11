package com.example.my_news_app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomViewHolder extends RecyclerView.ViewHolder {

    public TextView text_title, text_source;
    public CardView cardView;
    public ImageView img_headline;

    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);

        text_source = itemView.findViewById(R.id.text_source_id);
        img_headline = itemView.findViewById(R.id.img_headline_id);
        text_title = itemView.findViewById(R.id.text_title_id);
        cardView = itemView.findViewById(R.id.main_card_view_id);

    }
}
