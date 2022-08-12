package com.example.when_where_whatv3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class detailedActivity extends AppCompatActivity {

    Headlines headlines;
    TextView textTitle , author , time , detail, content;
    ImageView imgNews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        textTitle = findViewById(R.id.textDetail);
        author = findViewById(R.id.textDetailAuthor);
        time = findViewById(R.id.textDetailTime);
        detail = findViewById(R.id.textDetailFull);
        content = findViewById(R.id.textContent);
        imgNews = findViewById(R.id.imgDetail);

        headlines = (Headlines) getIntent().getSerializableExtra("data");

        textTitle.setText(headlines.getTitle());
        author.setText(headlines.getAuthor());
        time.setText(headlines.getPublishedAt());
        detail.setText(headlines.getDescription());
        content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(imgNews);

    }
}