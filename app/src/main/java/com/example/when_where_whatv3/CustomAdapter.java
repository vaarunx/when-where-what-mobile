package com.example.when_where_whatv3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecycleViewHolder> {

    private Context context; //Make them private
    private List<Headlines> headlines; //Make them private
    private SelectListener listener;

    public CustomAdapter(Context context, List<Headlines> headlines, SelectListener listener) {
        this.context = context;
        this.headlines = headlines;
        this.listener = listener;

    }

//    public Context getContext() {
//        return context;
//    }
//
//    public void setContext(Context context) {
//        this.context = context;
//    }
//
//    public List<Headlines> getHeadlines() {
//        return headlines;
//    }
//
//    public void setHeadlines(List<Headlines> headlines) {
//        this.headlines = headlines;
//    }

    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecycleViewHolder(LayoutInflater.from(context).inflate(R.layout.list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewHolder holder, int position) {
        holder.title.setText(headlines.get(position).getTitle());
        holder.source.setText(headlines.get(position).getSource().getName());
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.newsClicked(headlines.get(position));
            }
        });

        if(headlines.get(position).getUrlToImage()!= null){
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.imgView);

        }
    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
