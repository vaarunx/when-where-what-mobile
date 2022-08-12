package com.example.when_where_whatv3;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleViewHolder extends RecyclerView.ViewHolder {

    TextView title , source;
    ImageView imgView;
    CardView card;

    public RecycleViewHolder(@NonNull View itemView) {
        super(itemView);

        title = itemView.findViewById(R.id.title);
        source = itemView.findViewById(R.id.src);
        imgView = itemView.findViewById(R.id.image_headline);
        card = itemView.findViewById(R.id.main_container);
    }
}
