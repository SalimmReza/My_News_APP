package com.example.my_news_app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Custon_view_holder extends RecyclerView.ViewHolder {

        TextView title , source;
        ImageView headline;
        CardView cardView;

    public Custon_view_holder(@NonNull View itemView) {
        super(itemView);

    title = itemView.findViewById(R.id.text_title_id);
        source = itemView.findViewById(R.id.text_source_id);
        headline = itemView.findViewById(R.id.img_headline_id);
        cardView = itemView.findViewById(R.id.main_card_view_id);

    }
}
